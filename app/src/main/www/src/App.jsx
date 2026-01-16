import { useEffect } from 'react';
import Header from './components/Header';
import VehicleSection from './components/VehicleSection';
import AstonMartinSection from './components/AstonMartinSection';
import { favoritosVehicles, suvVehicles } from './data/vehicles';
import './App.css';
const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;
const ScrollSmoother = window.ScrollSmoother;
gsap.registerPlugin(ScrollTrigger, ScrollSmoother);

function App() {

  useEffect(() => {
    const smoother = ScrollSmoother.create({
      wrapper: '#smooth-wrapper',
      content: '#smooth-content',
      smooth: 1.5,
      effects: true,
      smoothTouch: 0.1,
    });
    const handleScroll = () => {
      const header = document.querySelector('.header');
      if (window.scrollY > 100) {
        header?.classList.add('scrolled');
      } else {
        header?.classList.remove('scrolled');
      }
    };

    window.addEventListener('scroll', handleScroll);

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
            <AstonMartinSection />
            
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
            
            <section id="ver-mas" className="ver-mas-section">
              <h2>¿Quieres ver más?</h2>
              <a href="#catalogo" className="btn-ver-catalogo">Ver Catálogo</a>
            </section>
          </main>
        </div>
      </div>
    </>
  );
}

export default App;
