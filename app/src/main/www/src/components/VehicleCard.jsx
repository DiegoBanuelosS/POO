import { useRef, useEffect } from 'react';
import './VehicleCard.css';
const gsap = window.gsap;
const SplitText = window.SplitText;

const VehicleCard = ({ tipo = 'tipo', precio = '$00,000', nombre = 'Nombre del Vehículo', imagen = 'https://images.unsplash.com/photo-1494976388531-d1058494cdd8?w=400&h=300&fit=crop' }) => {
  const buttonRef = useRef(null);
  const textRef = useRef(null);
  const splitRef = useRef(null);
  const isAnimatingRef = useRef(false);
  const currentTextRef = useRef(precio);

  useEffect(() => {
    if (!textRef.current || !buttonRef.current) return;

    document.fonts.ready.then(() => {
      splitRef.current = new SplitText(textRef.current, { type: 'chars' });
    });

    return () => {
      if (splitRef.current) splitRef.current.revert();
    };
  }, []);

  const animateTextChange = (newText, isEnter) => {
    if (isAnimatingRef.current || currentTextRef.current === newText) return;
    isAnimatingRef.current = true;
    currentTextRef.current = newText;
    
    gsap.to(splitRef.current.chars, {
      y: isEnter ? -25 : 25,
      opacity: 0,
      rotationX: isEnter ? -80 : 80,
      stagger: { each: 0.015, from: isEnter ? 'start' : 'end' },
      duration: 0.2,
      ease: 'power2.in',
      onComplete: () => {
        splitRef.current.revert();
        textRef.current.textContent = newText;
        splitRef.current = new SplitText(textRef.current, { type: 'chars' });
        
        gsap.fromTo(splitRef.current.chars, 
          { 
            y: isEnter ? 25 : -25, 
            opacity: 0,
            rotationX: isEnter ? 80 : -80
          },
          {
            y: 0,
            opacity: 1,
            rotationX: 0,
            stagger: { each: 0.02, from: isEnter ? 'start' : 'end' },
            duration: 0.3,
            ease: 'back.out(1.5)',
            onComplete: () => {
              isAnimatingRef.current = false;
            }
          }
        );
      }
    });
  };

  const handleMouseEnter = () => {
    animateTextChange('Ver más', true);
    gsap.to(buttonRef.current, {
      scale: 1.05,
      backgroundColor: '#333',
      duration: 0.3,
      ease: 'power2.out'
    });
  };

  const handleMouseLeave = () => {
    animateTextChange(precio, false);
    gsap.to(buttonRef.current, {
      scale: 1,
      backgroundColor: '#000',
      duration: 0.3,
      ease: 'power2.out'
    });
  };

  return (
    <div className="vehicle-card">
      <div className="card-image">
        <img src={imagen} alt={nombre} className="card-img" />
        <span className="card-type">{tipo}</span>
      </div>
      <div className="card-info">
        <h3 className="card-name">{nombre}</h3>
        <button 
          ref={buttonRef} 
          className="card-price"
          onMouseEnter={handleMouseEnter}
          onMouseLeave={handleMouseLeave}
        >
          <span ref={textRef} className="price-text">{precio}</span>
        </button>
      </div>
    </div>
  );
};

export default VehicleCard;
