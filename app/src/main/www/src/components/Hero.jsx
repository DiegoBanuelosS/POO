import { useEffect, useRef } from 'react';
import './Hero.css';

const gsap = window.gsap;
const SplitText = window.SplitText;

const Hero = () => {
  const titleRef = useRef(null);

  useEffect(() => {
    // Wait for fonts to load before using SplitText
    document.fonts.ready.then(() => {
      const split = new SplitText(titleRef.current, { type: 'chars, words' });
      
      gsap.fromTo(split.chars, 
        {
          opacity: 0,
          y: 80,
          rotationX: -90
        },
        {
          opacity: 1,
          y: 0,
          rotationX: 0,
          duration: 1,
          stagger: 0.03,
          ease: 'back.out(1.7)',
          delay: 0.3
        }
      );
    });
  }, []);

  return (
    <section className="hero">
      <div className="hero-overlay"></div>
      <h1 className="hero-title" ref={titleRef}>
        Tu Nuevo Vehiculo a un paso
      </h1>
    </section>
  );
};

export default Hero;
