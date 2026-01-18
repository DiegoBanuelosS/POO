import { useEffect, useRef, useState } from 'react';
import Header from '../components/Header';
import VehicleCard from '../components/VehicleCard';
import VehicleDetailModal from '../components/VehicleDetailModal';
import { catalogoCompleto } from '../data/catalogoCompleto';
import './Catalogo.css';

const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;
const ScrollSmoother = window.ScrollSmoother;
gsap.registerPlugin(ScrollTrigger, ScrollSmoother);

function Catalogo() {
  const heroRef = useRef(null);
  const heroTitleRef = useRef(null);
  const heroSubtitleRef = useRef(null);
  const filterButtonsRef = useRef([]);
  const vehicleCardsRef = useRef([]);
  const categoriesRef = useRef(null);
  const statsRef = useRef([]);
  
  const [filtroActivo, setFiltroActivo] = useState('todos');
  const [vehiculosFiltrados, setVehiculosFiltrados] = useState([]);
  const [vehiculoSeleccionado, setVehiculoSeleccionado] = useState(null);

  const todosLosVehiculos = catalogoCompleto;

  const categorias = [
    { id: 'todos', nombre: 'Todos', count: todosLosVehiculos.length },
    { id: 'deportivo', nombre: 'Deportivos', count: todosLosVehiculos.filter(v => v.categoria === 'deportivo').length },
    { id: 'suv', nombre: 'SUV', count: todosLosVehiculos.filter(v => v.categoria === 'suv').length },
    { id: 'sedan', nombre: 'Sedan', count: todosLosVehiculos.filter(v => v.categoria === 'sedan').length },
    { id: 'hibrido', nombre: 'Híbrido', count: todosLosVehiculos.filter(v => v.categoria === 'hibrido').length },
    { id: 'luxury', nombre: 'Luxury', count: todosLosVehiculos.filter(v => v.categoria === 'luxury').length },
  ];

  useEffect(() => {
    filtrarVehiculos(filtroActivo);
  }, [filtroActivo]);

  const filtrarVehiculos = (categoria) => {
    let vehiculos = [];
    
    if (categoria === 'todos') {
      vehiculos = todosLosVehiculos;
    } else {
      vehiculos = todosLosVehiculos.filter(v => 
        v.categoria === categoria
      );
    }
    
    setVehiculosFiltrados(vehiculos);
  };

  const handleFiltroClick = (categoria) => {
    setFiltroActivo(categoria);
    
    // Filtrar sin animación para mejor rendimiento
    filtrarVehiculos(categoria);
  };

  useEffect(() => {
    const smoother = ScrollSmoother.create({
      wrapper: '#catalog-smooth-wrapper',
      content: '#catalog-smooth-content',
      smooth: 1,
      effects: false,
      smoothTouch: 0,
    });

    // Animación del Hero
    if (heroRef.current && heroTitleRef.current && heroSubtitleRef.current) {
      gsap.set([heroTitleRef.current, heroSubtitleRef.current], { 
        opacity: 0, 
        y: 100,
        filter: 'blur(20px)'
      });

      gsap.to(heroTitleRef.current, {
        opacity: 1,
        y: 0,
        filter: 'blur(0px)',
        duration: 1.2,
        delay: 0.3,
        ease: 'power3.out'
      });

      gsap.to(heroSubtitleRef.current, {
        opacity: 1,
        y: 0,
        filter: 'blur(0px)',
        duration: 1.2,
        delay: 0.6,
        ease: 'power3.out'
      });
    }

    // Animación de los filtros
    if (filterButtonsRef.current.length > 0) {
      gsap.set(filterButtonsRef.current, { opacity: 0, y: 30 });
      
      gsap.to(filterButtonsRef.current, {
        opacity: 1,
        y: 0,
        duration: 0.6,
        stagger: 0.1,
        delay: 0.9,
        ease: 'power2.out'
      });
    }

    // Animación de las tarjetas de vehículos
    if (vehicleCardsRef.current.length > 0) {
      gsap.set(vehicleCardsRef.current, { opacity: 0, y: 50, scale: 0.9 });
      
      gsap.to(vehicleCardsRef.current, {
        opacity: 1,
        y: 0,
        scale: 1,
        duration: 0.6,
        stagger: 0.05,
        delay: 1.2,
        ease: 'power2.out',
        scrollTrigger: {
          trigger: '.catalogo-grid',
          start: 'top 80%',
          toggleActions: 'play none none none'
        }
      });
    }

    // Animación de estadísticas
    if (categoriesRef.current && statsRef.current.length > 0) {
      gsap.set(statsRef.current, { opacity: 0, y: -30 });
      
      gsap.to(statsRef.current, {
        opacity: 1,
        y: 0,
        duration: 0.8,
        stagger: 0.15,
        ease: 'power2.out',
        scrollTrigger: {
          trigger: categoriesRef.current,
          start: 'top 80%',
          toggleActions: 'play none none none'
        }
      });
    }

    return () => {
      smoother.kill();
      ScrollTrigger.getAll().forEach(trigger => trigger.kill());
    };
  }, []);

  return (
    <>
      <Header />
      
      <div id="catalog-smooth-wrapper">
        <div id="catalog-smooth-content">
          {/* Hero Section */}
          <section className="catalogo-hero" ref={heroRef}>
            <div className="catalogo-hero-overlay"></div>
            <div className="catalogo-hero-content">
              <h1 ref={heroTitleRef}>Catálogo Completo</h1>
              <p ref={heroSubtitleRef}>Descubre nuestra exclusiva colección de vehículos de lujo</p>
            </div>
            <div className="catalogo-hero-scroll">
              <span>Scroll</span>
              <div className="scroll-line"></div>
            </div>
          </section>

          {/* Categorías con Estadísticas */}
          <section className="catalogo-categories" ref={categoriesRef}>
            <div className="categories-container">
              <h2>Explorar por categoría</h2>
              <div className="categories-stats">
                {categorias.filter(cat => cat.id !== 'todos').map((cat, index) => (
                  <div 
                    key={cat.id} 
                    className="stat-card"
                    ref={el => { if (el) statsRef.current[index] = el; }}
                  >
                    <div className="stat-number">{cat.count}</div>
                    <div className="stat-label">{cat.nombre}</div>
                  </div>
                ))}
              </div>
            </div>
          </section>

          {/* Filtros */}
          <section className="catalogo-filters">
            <div className="filters-container">
              {categorias.map((categoria, index) => (
                <button
                  key={categoria.id}
                  ref={el => { if (el) filterButtonsRef.current[index] = el; }}
                  className={`filter-btn ${filtroActivo === categoria.id ? 'active' : ''}`}
                  onClick={() => handleFiltroClick(categoria.id)}
                >
                  <span className="filter-name">{categoria.nombre}</span>
                  <span className="filter-count">{categoria.count}</span>
                </button>
              ))}
            </div>
          </section>

          {/* Grid de Vehículos */}
          <section className="catalogo-vehicles">
            <div className="catalogo-grid">
              {vehiculosFiltrados.map((vehiculo, index) => (
                <div 
                  key={`${vehiculo.nombre}-${index}`}
                  ref={el => { if (el) vehicleCardsRef.current[index] = el; }}
                  className="catalogo-vehicle-wrapper"
                >
                  <VehicleCard
                    nombre={vehiculo.nombre}
                    tipo={vehiculo.tipo}
                    precio={vehiculo.precio}
                    imagen={vehiculo.media ? vehiculo.media[0]?.url : vehiculo.imagenes?.[0]}
                    onClick={() => setVehiculoSeleccionado(vehiculo)}
                  />
                </div>
              ))}
            </div>
          </section>

          {/* CTA Final */}
          <section className="catalogo-cta">
            <div className="cta-container">
              <h2>¿No encontraste lo que buscabas?</h2>
              <p>Contáctanos y te ayudaremos a encontrar el vehículo perfecto para ti</p>
              <button className="cta-button">Contactar Asesor</button>
            </div>
          </section>
        </div>
      </div>

      {/* Modal de detalle */}
      {vehiculoSeleccionado && (
        <VehicleDetailModal 
          vehiculo={vehiculoSeleccionado}
          onClose={() => setVehiculoSeleccionado(null)}
        />
      )}
    </>
  );
}

export default Catalogo;
