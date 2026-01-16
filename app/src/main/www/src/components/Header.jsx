import { useEffect, useState, useRef } from 'react';
import './Header.css';
import logo from '../assets/logo.svg';

const Header = () => {
  const [isDarkLogo, setIsDarkLogo] = useState(false);
  const [isInVideoSection, setIsInVideoSection] = useState(true);
  const [isNavbarOpen, setIsNavbarOpen] = useState(false);
  const headerRef = useRef(null);

  useEffect(() => {
    const header = headerRef.current;
    if (!header) return;

    const checkCurrentSection = () => {
      const headerRect = header.getBoundingClientRect();
      const checkY = headerRect.bottom;

      // Secciones donde el logo debe ser negro
      const darkSections = ['vehiculos', 'catalogo', 'cars'];
      
      // Detectar si está en la sección sobre-nosotros (logo blanco)
      const sobreNosotrosSection = document.getElementById('sobre-nosotros');
      if (sobreNosotrosSection) {
        const sobreNosotrosRect = sobreNosotrosSection.getBoundingClientRect();
        if (sobreNosotrosRect.top <= checkY && sobreNosotrosRect.bottom >= 0) {
          setIsInVideoSection(true);
          setIsNavbarOpen(false);
          setIsDarkLogo(false);
          return;
        }
      }
      
      // Detectar si está en la sección ver-mas (logo blanco)
      const verMasSection = document.getElementById('ver-mas');
      if (verMasSection) {
        const verMasRect = verMasSection.getBoundingClientRect();
        if (verMasRect.top <= checkY && verMasRect.bottom >= 0) {
          setIsInVideoSection(false);
          setIsNavbarOpen(true);
          setIsDarkLogo(false);
          return;
        }
      }
      
      // Detectar si está en la sección de estadísticas (fondo blanco - logo negro)
      const estadisticasSection = document.getElementById('estadisticas');
      if (estadisticasSection) {
        const estadisticasRect = estadisticasSection.getBoundingClientRect();
        if (estadisticasRect.top <= checkY && estadisticasRect.bottom >= 0) {
          setIsInVideoSection(false);
          setIsNavbarOpen(true);
          setIsDarkLogo(true);
          return;
        }
      }
      
      // Detectar si está en la sección de transporte (fondo blanco inicial - logo negro)
      const transporteSection = document.querySelector('.transporte-section');
      if (transporteSection) {
        const transporteRect = transporteSection.getBoundingClientRect();
        if (transporteRect.top <= checkY && transporteRect.bottom >= 0) {
          setIsInVideoSection(false);
          setIsNavbarOpen(true);
          setIsDarkLogo(true);
          return;
        }
      }
      
      // Detectar si está en la sección de videos
      const videoSection = document.getElementById('aston-martin');
      if (videoSection) {
        const videoRect = videoSection.getBoundingClientRect();
        if (videoRect.top <= checkY && videoRect.bottom >= 0) {
          setIsInVideoSection(true);
          setIsNavbarOpen(false);
          setIsDarkLogo(false);
          return;
        }
      }
      
      setIsInVideoSection(false);
      setIsNavbarOpen(true);
      
      for (const sectionId of darkSections) {
        const section = document.getElementById(sectionId);
        if (section) {
          const sectionRect = section.getBoundingClientRect();
          if (sectionRect.top <= checkY && sectionRect.bottom >= 0) {
            setIsDarkLogo(true);
            return;
          }
        }
      }
      
      setIsDarkLogo(false);
    };

    const handleScroll = () => {
      checkCurrentSection();
    };

    const sections = document.querySelectorAll('section');
    const observer = new IntersectionObserver(
      () => {
        checkCurrentSection();
      },
      {
        root: null,
        threshold: [0, 0.1, 0.5, 1],
        rootMargin: '0px'
      }
    );

    sections.forEach((section) => observer.observe(section));
    window.addEventListener('scroll', handleScroll);
    
    checkCurrentSection();

    return () => {
      observer.disconnect();
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  const toggleNavbar = () => {
    if (isInVideoSection) {
      setIsNavbarOpen(!isNavbarOpen);
    }
  };

  const scrollToTop = () => {
    // Desbloquear el scroll antes de subir
    document.body.style.overflow = '';
    document.body.style.overflowX = 'hidden';
    
    // Scroll suave hacia arriba
    window.scrollTo({ top: 0, behavior: 'smooth' });
  };

  return (
    <header ref={headerRef} className={`header ${isInVideoSection ? 'video-section' : ''}`}>
      <a href="#" className={`nav-logo ${isDarkLogo ? 'dark' : ''}`}>
        <img src={logo} alt="Logo" className="logo" />
      </a>
      
      {/* Línea minimizada */}
      {isInVideoSection && !isNavbarOpen && (
        <div className="navbar-minimized" onClick={toggleNavbar}>
          <span className="navbar-line"></span>
        </div>
      )}
      
      {/* Navbar normal o expandido */}
      <nav className={`navbar ${isInVideoSection ? (isNavbarOpen ? 'expanded' : 'collapsed') : ''}`}>
        <a href="#vehiculos" className="nav-link">inicio</a>
        <a href="#catalogo" className="nav-link">catalogo</a>
        <a href="#pedido" className="nav-link">pedido personalizado</a>
        <a href="#ver-mas" className="nav-link">sobre nosotros</a>
        
        {isInVideoSection && isNavbarOpen && (
          <button className="navbar-close" onClick={toggleNavbar}>
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
              <line x1="18" y1="6" x2="6" y2="18"></line>
              <line x1="6" y1="6" x2="18" y2="18"></line>
            </svg>
          </button>
        )}
      </nav>
    </header>
  );
};

export default Header;
