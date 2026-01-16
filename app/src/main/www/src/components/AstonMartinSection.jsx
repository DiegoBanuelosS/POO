import { useState, useRef, useEffect } from 'react';
import './AstonMartinSection.css';
import astonLogo from '../assets/aston-martin-svgrepo-com.svg';
import lamborghiniLogo from '../assets/lamborghini-svgrepo-com.svg';
import porscheLogo from '../assets/porsche-svgrepo-com.svg';
import lamborghiniVideo from '../assets/Lamborghini_Temerario_ENDLESS_PROGRESSION_16x9.mp4_(HD_720_-_WEB_(H264_2500)).mp4';

const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;

const vehicles = [
  {
    id: 1,
    name: 'Aston Martin Vantage',
    logo: astonLogo,
    video: 'https://www.astonmartin.com/-/media/aston-martin/videos/model-carousel-updates/video-updates/vantage-s-gaydon-desktop.mp4?rev=9bbff2bb2f7f45fe8923510b6f868a6b',
    fontClass: 'font-aston'
  },
  {
    id: 2,
    name: 'Lamborghini Temerario',
    logo: lamborghiniLogo,
    video: lamborghiniVideo,
    fontClass: 'font-lambo'
  },
  {
    id: 3,
    name: 'Porsche Taycan',
    logo: porscheLogo,
    video: 'https://videos.porsche.com/id/ef77e2f7-5306-47b1-bd55-f203102ce3d4/taycansnippetdesktop/hls.m3u8',
    fontClass: 'font-porsche'
  }
];

const AstonMartinSection = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [isTransitioning, setIsTransitioning] = useState(false);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [isAnimating, setIsAnimating] = useState(false);
  const [isFullscreen, setIsFullscreen] = useState(false);
  const videoRef = useRef(null);
  const sectionRef = useRef(null);
  const videoContainerRef = useRef(null);
  const contentRef = useRef(null);
  const loaderRef = useRef(null);

  const currentVehicle = vehicles[currentIndex];

  useEffect(() => {
    const video = videoRef.current;
    if (video) {
      const handleCanPlay = () => {
        setIsLoading(false);
      };

      video.addEventListener('canplaythrough', handleCanPlay);
      
      const timeout = setTimeout(() => {
        setIsLoading(false);
      }, 5000);

      return () => {
        video.removeEventListener('canplaythrough', handleCanPlay);
        clearTimeout(timeout);
      };
    }
  }, [currentIndex]);

  useEffect(() => {
    const section = sectionRef.current;
    const videoContainer = videoContainerRef.current;
    const content = contentRef.current;
    
    if (!section || !videoContainer || !content) return;

    // Mostrar contenido inicialmente (empieza en fullscreen)
    gsap.set(content, { opacity: 1, filter: 'blur(0px)' });
    setIsFullscreen(true);

    const ctx = gsap.context(() => {
      gsap.fromTo(videoContainer, 
        {
          scale: 1,
          borderRadius: '0px'
        },
        {
          scale: 0.6,
          borderRadius: '40px',
          ease: 'none',
          scrollTrigger: {
            trigger: section,
            start: 'top top',
            end: '+=100%',
            pin: true,
            pinSpacing: true,
            scrub: 1,
            onUpdate: (self) => {
              if (self.progress <= 0.01) {
                setIsFullscreen(true);
                // Contenido visible cuando está en fullscreen
                gsap.to(content, {
                  opacity: 1,
                  filter: 'blur(0px)',
                  duration: 0.8,
                  ease: 'power2.out'
                });
              } else {
                setIsFullscreen(false);
                gsap.to(content, {
                  opacity: 0,
                  filter: 'blur(20px)',
                  duration: 0.3
                });
              }
            }
          }
        }
      );
    }, section);

    return () => {
      ctx.revert();
    };
  }, []);

  const handlePrev = () => {
    if (currentIndex === 0 || isAnimating) return;
    
    setIsAnimating(true);
    setIsTransitioning(true);
    const content = contentRef.current;
    const videoContainer = videoContainerRef.current;
    
    // Fade out del video actual
    gsap.to(videoContainer, {
      opacity: 0,
      duration: 0.5,
      ease: 'power2.inOut'
    });
    
    gsap.to(content, {
      opacity: 0,
      filter: 'blur(20px)',
      duration: 0.4,
      onComplete: () => {
        setCurrentIndex(prev => prev - 1);
        setIsLoading(true);
        
        // Fade in del nuevo video
        gsap.to(videoContainer, {
          opacity: 1,
          duration: 0.6,
          delay: 0.3,
          ease: 'power2.out'
        });
        
        gsap.to(content, {
          opacity: 1,
          filter: 'blur(0px)',
          duration: 0.6,
          delay: 0.5,
          onComplete: () => {
            setIsAnimating(false);
            setIsTransitioning(false);
          }
        });
      }
    });
  };

  const handleNext = () => {
    if (currentIndex === vehicles.length - 1 || isAnimating) return;
    
    setIsAnimating(true);
    setIsTransitioning(true);
    const content = contentRef.current;
    const videoContainer = videoContainerRef.current;
    
    // Fade out del video actual
    gsap.to(videoContainer, {
      opacity: 0,
      duration: 0.5,
      ease: 'power2.inOut'
    });
    
    gsap.to(content, {
      opacity: 0,
      filter: 'blur(20px)',
      duration: 0.4,
      onComplete: () => {
        setCurrentIndex(prev => prev + 1);
        setIsLoading(true);
        
        // Fade in del nuevo video
        gsap.to(videoContainer, {
          opacity: 1,
          duration: 0.6,
          delay: 0.3,
          ease: 'power2.out'
        });
        
        gsap.to(content, {
          opacity: 1,
          filter: 'blur(0px)',
          duration: 0.6,
          delay: 0.5,
          onComplete: () => {
            setIsAnimating(false);
            setIsTransitioning(false);
          }
        });
      }
    });
  };

  return (
    <section id="aston-martin" className="aston-martin-section" ref={sectionRef}>
      <div className="aston-video-container" ref={videoContainerRef}>
        {/* Loader con transición gradual */}
        <div className={`aston-loader ${isLoading ? 'visible' : ''}`} ref={loaderRef}>
          <img src={currentVehicle.logo} alt="Loading" className="aston-loader-logo" />
        </div>
        
        {/* Video de fondo */}
        <video
          ref={videoRef}
          className="aston-video"
          autoPlay
          loop
          muted
          playsInline
          key={currentVehicle.id}
        >
          <source src={currentVehicle.video} type="video/mp4" />
        </video>

        {/* Logo en esquina superior derecha */}
        <div className="aston-brand-logo">
          <img src={currentVehicle.logo} alt="Brand" />
        </div>

        {/* Overlay oscuro */}
        <div className="aston-overlay"></div>

        {/* Flechas de navegación */}
        {isFullscreen && (
          <>
            <button 
              className={`carousel-arrow arrow-left ${currentIndex === 0 ? 'disabled' : ''}`}
              onClick={handlePrev}
              disabled={currentIndex === 0}
            >
              <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                <polyline points="15,18 9,12 15,6"></polyline>
              </svg>
            </button>
            <button 
              className={`carousel-arrow arrow-right ${currentIndex === vehicles.length - 1 ? 'disabled' : ''}`}
              onClick={handleNext}
              disabled={currentIndex === vehicles.length - 1}
            >
              <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                <polyline points="9,18 15,12 9,6"></polyline>
              </svg>
            </button>
          </>
        )}

        {/* Contenido */}
        <div className="aston-content" ref={contentRef}>
          <h2 className={`aston-title ${currentVehicle.fontClass}`}>{currentVehicle.name}</h2>
          <a href="#" className="aston-link">Comprar</a>
        </div>
      </div>
    </section>
  );
};

export default AstonMartinSection;
