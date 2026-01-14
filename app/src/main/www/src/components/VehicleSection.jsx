import { useEffect, useRef } from 'react';
import VehicleCard from './VehicleCard';
import './VehicleSection.css';

const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;

const VehicleSection = ({ id, title, showButton = false, vehicles = [] }) => {
  const sectionRef = useRef(null);
  const titleRef = useRef(null);
  const gridRef = useRef(null);
  const buttonRef = useRef(null);

  useEffect(() => {
    const ctx = gsap.context(() => {
      // Title reveal animation
      gsap.from(titleRef.current, {
        scrollTrigger: {
          trigger: titleRef.current,
          start: 'top 90%',
        },
        opacity: 0,
        y: 30,
        duration: 0.8,
        ease: 'power2.out'
      });

      // Cards reveal animation
      const cards = gridRef.current.querySelectorAll('.vehicle-card');
      gsap.from(cards, {
        scrollTrigger: {
          trigger: gridRef.current,
          start: 'top 85%',
        },
        opacity: 0,
        y: 40,
        duration: 0.6,
        stagger: 0.1,
        ease: 'power2.out'
      });

      // Button reveal animation
      if (buttonRef.current) {
        gsap.from(buttonRef.current, {
          scrollTrigger: {
            trigger: buttonRef.current,
            start: 'top 95%',
          },
          opacity: 0,
          y: 20,
          duration: 0.5,
          ease: 'power2.out'
        });
      }
    }, sectionRef);

    return () => ctx.revert();
  }, []);

  return (
    <section className="section" id={id} ref={sectionRef}>
      <h2 className="section-title" ref={titleRef}>{title}</h2>
      <div className="vehicles-grid" ref={gridRef}>
        {vehicles.map((vehicle, index) => (
          <VehicleCard 
            key={index} 
            tipo={vehicle.tipo} 
            precio={vehicle.precio}
            nombre={vehicle.nombre}
            imagen={vehicle.imagen}
          />
        ))}
      </div>
      {showButton && (
        <button className="btn-ver-mas" ref={buttonRef}>Ver mas</button>
      )}
    </section>
  );
};

export default VehicleSection;
