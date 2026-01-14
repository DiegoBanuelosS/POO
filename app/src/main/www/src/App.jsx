import { useEffect } from 'react';
import Header from './components/Header';
import Hero from './components/Hero';
import VehicleSection from './components/VehicleSection';
import { favoritosVehicles, suvVehicles } from './data/vehicles';
import './App.css';

// Get GSAP from window (loaded via CDN)
const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;
const ScrollSmoother = window.ScrollSmoother;

// Register plugins
gsap.registerPlugin(ScrollTrigger, ScrollSmoother);

function App() {

  useEffect(() => {
    // Initialize ScrollSmoother
    const smoother = ScrollSmoother.create({
      wrapper: '#smooth-wrapper',
      content: '#smooth-content',
      smooth: 1.5,
      effects: true,
      smoothTouch: 0.1,
    });

    // Header scroll effect
    const handleScroll = () => {
      const header = document.querySelector('.header');
      if (window.scrollY > 100) {
        header?.classList.add('scrolled');
      } else {
        header?.classList.remove('scrolled');
      }
    };

    window.addEventListener('scroll', handleScroll);

    // Parallax effect on hero
    gsap.to('.hero', {
      scrollTrigger: {
        trigger: '.hero',
        start: 'top top',
        end: 'bottom top',
        scrub: true
      },
      backgroundPosition: '50% 100%',
      ease: 'none'
    });

    return () => {
      smoother.kill();
      window.removeEventListener('scroll', handleScroll);
      ScrollTrigger.getAll().forEach(trigger => trigger.kill());
    };
  }, []);

  return (
    <>
      {/* Header fixed */}
      <Header />
      
      {/* ScrollSmoother wrapper */}
      <div id="smooth-wrapper">
        <div id="smooth-content">
          <main>
            <Hero />
            
            <VehicleSection 
              id="vehiculos" 
              title="Nuestros Favoritos" 
              showButton={true}
              vehicles={favoritosVehicles}
            />
            
            <VehicleSection 
              id="catalogo" 
              title="Nuestros SUV" 
              showButton={false}
              vehicles={suvVehicles}
            />
            
            <div className="footer-space"></div>
          </main>
        </div>
      </div>
    </>
  );
}

export default App;
