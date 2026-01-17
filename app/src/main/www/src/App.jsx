import { useEffect, useRef } from 'react';
import Header from './components/Header';
import VehicleSection from './components/VehicleSection';
import AstonMartinSection from './components/AstonMartinSection';
import { favoritosVehicles, suvVehicles } from './data/vehicles';
import { bentoImages } from './data/bentoImages';
import logo from './assets/logo.svg';
import costumize2 from "./data/Assets/about/PF0009455_264.mp4"
import customize1 from "./data/Assets/about/Lamborghini_Ad_Personam_(HD_720_-_WEB_(H264_2500)).mp4"
import luxuryVideo from './data/Assets/about/Lamborghini_Temerario_ENDLESS_PROGRESSION_916.mp4_(HD_720_-_WEB_(H264_2500)).mp4';
import './App.css';
const gsap = window.gsap;
const ScrollTrigger = window.ScrollTrigger;
const ScrollSmoother = window.ScrollSmoother;
gsap.registerPlugin(ScrollTrigger, ScrollSmoother);

function App() {
  const verMasRef = useRef(null);
  const bentoItemsRef = useRef([]);
  const sobreNosotrosLogoRef = useRef(null);
  const sobreNosotrosTextRef = useRef(null);
  const estadisticasRef = useRef(null);
  const contadorRef = useRef(null);
  const textoContadorRef = useRef(null);
  const reviewsRef = useRef([]);
  const transporteRef = useRef(null);
  const transporteImageRef = useRef(null);
  const personalizacionRef = useRef(null);
  const personalizacionVideosRef = useRef([]);

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

    // Animación para la sección "¿Quieres ver más?"
    if (verMasRef.current) {
      const title = verMasRef.current.querySelector('h2');
      const button = verMasRef.current.querySelector('.btn-ver-catalogo');

      gsap.set([title, button], { opacity: 0, y: 50 });
      gsap.set(bentoItemsRef.current, { opacity: 0, scale: 0.9, filter: 'blur(20px)' });

      // Animación de las imágenes del bento - una por una con blur
      gsap.to(bentoItemsRef.current, {
        opacity: 1,
        scale: 1,
        filter: 'blur(0px)',
        duration: 0.8,
        stagger: 0.15,
        ease: 'power2.out',
        scrollTrigger: {
          trigger: verMasRef.current,
          start: 'top 70%',
          end: 'bottom 30%',
          toggleActions: 'play reverse play reverse'
        }
      });

      gsap.to(title, {
        opacity: 1,
        y: 0,
        duration: 1,
        delay: 1.3,
        ease: 'power3.out',
        scrollTrigger: {
          trigger: verMasRef.current,
          start: 'top 80%',
          toggleActions: 'play none none none'
        }
      });

      gsap.to(button, {
        opacity: 1,
        y: 0,
        duration: 1,
        delay: 1.6,
        ease: 'power3.out',
        scrollTrigger: {
          trigger: verMasRef.current,
          start: 'top 80%',
          toggleActions: 'play none none none'
        }
      });
    }
    // Animación para la sección "Sobre Nosotros"
    if (sobreNosotrosLogoRef.current && sobreNosotrosTextRef.current) {
      gsap.set([sobreNosotrosLogoRef.current, sobreNosotrosTextRef.current], { 
        opacity: 0, 
        scale: 0.5,
        y: 100
      });

      gsap.timeline({
        scrollTrigger: {
          trigger: '#sobre-nosotros',
          start: 'center center',
          end: '+=1000',
          pin: true,
          scrub: 1,
        }
      })
      .to(sobreNosotrosLogoRef.current, {
        opacity: 1,
        scale: 1,
        y: 0,
        duration: 0.5,
        ease: 'back.out(1.5)',
      })
      .to(sobreNosotrosTextRef.current, {
        opacity: 1,
        scale: 1,
        y: 0,
        duration: 0.5,
        ease: 'power3.out',
      }, '-=0.2');
    }
    // Animación para la sección de Estadísticas con scroll bloqueado
    if (estadisticasRef.current && contadorRef.current && textoContadorRef.current) {
      const tl = gsap.timeline({
        scrollTrigger: {
          trigger: estadisticasRef.current,
          start: 'center center',
          end: '+=3000',
          pin: true,
          scrub: 1,
        }
      });

      // Primera estadística: Personas (0-20,000)
      tl.to({}, {
        duration: 0.3,
        onStart: function() {
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(10px)',
            opacity: 0,
            duration: 0.3
          });
        }
      })
      .to({}, {
        duration: 2,
        onStart: function() {
          contadorRef.current.textContent = '0+';
          textoContadorRef.current.textContent = 'Personas Confian en nosotros';
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(0px)',
            opacity: 1,
            duration: 0.3
          });
        },
        onUpdate: function() {
          const progress = this.progress();
          const value = Math.floor(20000 * progress);
          contadorRef.current.textContent = value.toLocaleString() + '+';
          gsap.set(reviewsRef.current, { opacity: 0 });
        }
      })
      // Pausa más larga
      .to({}, { duration: 0.8 })
      // Segunda estadística: Coches vendidos (0-65,000)
      .to({}, {
        duration: 0.3,
        onStart: function() {
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(10px)',
            opacity: 0,
            duration: 0.3
          });
        }
      })
      .to({}, {
        duration: 2,
        onStart: function() {
          contadorRef.current.textContent = '0+';
          textoContadorRef.current.textContent = 'Coches Vendidos';
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(0px)',
            opacity: 1,
            duration: 0.3
          });
        },
        onUpdate: function() {
          const progress = this.progress();
          const value = Math.floor(65000 * progress);
          contadorRef.current.textContent = value.toLocaleString() + '+';
          gsap.set(reviewsRef.current, { opacity: 0 });
        }
      })
      // Pausa más larga
      .to({}, { duration: 0.8 })
      // Tercera estadística: Estrellas (0-5)
      .to({}, {
        duration: 0.3,
        onStart: function() {
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(10px)',
            opacity: 0,
            duration: 0.3
          });
        }
      })
      .to({}, {
        duration: 2,
        onStart: function() {
          contadorRef.current.innerHTML = '☆☆☆☆☆';
          textoContadorRef.current.textContent = 'Calificación de nuestros clientes';
          gsap.to([contadorRef.current, textoContadorRef.current], {
            filter: 'blur(0px)',
            opacity: 1,
            duration: 0.3
          });
        },
        onUpdate: function() {
          const progress = this.progress();
          const stars = Math.floor(5 * progress);
          contadorRef.current.innerHTML = '★'.repeat(stars) + '☆'.repeat(5 - stars);
        }
      })
      // Pausa antes de mostrar reviews
      .to({}, { duration: 0.5 })
      // Mostrar reviews
      .to(reviewsRef.current, {
        opacity: 1,
        duration: 1
      });
    }
    // Animación para la sección de Transporte
    if (transporteRef.current && transporteImageRef.current) {
      const title = transporteRef.current.querySelector('.transporte-title');
      const descripcion = transporteRef.current.querySelector('.transporte-descripcion');
      
      gsap.set(transporteImageRef.current, { opacity: 0 });
      
      gsap.timeline({
        scrollTrigger: {
          trigger: transporteRef.current,
          start: 'center center',
          end: '+=1500',
          pin: true,
          scrub: 1,
        }
      })
      .to([transporteImageRef.current, title, descripcion], {
        opacity: 1,
        color: '#ffffff',
        duration: 1
      }, 0);
    }

    // Animación para la sección de Personalización
    if (personalizacionRef.current && personalizacionVideosRef.current.length > 0) {
      const tl = gsap.timeline({
        scrollTrigger: {
          trigger: personalizacionRef.current,
          start: 'center center',
          end: '+=2000',
          pin: true,
          scrub: 1,
        }
      });

      // Los paneles se contraen para revelar el video detrás
      personalizacionVideosRef.current.forEach((panel, index) => {
        if (panel) {
          gsap.set(panel, { scaleX: 1 });
          
          tl.to(panel, {
            scaleX: 0,
            duration: 0.5,
            ease: 'power2.inOut',
          }, index * 0.2);
        }
      });
    }
    
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
            
            <section id="ver-mas" className="ver-mas-section" ref={verMasRef}>
              {/* Bento Grid de fondo */}
              <div className="bento-grid">
                <div className="bento-item bento-1" ref={(el) => { if (el) bentoItemsRef.current[0] = el; }}>
                  <img src={bentoImages[0].url} alt="" />
                </div>
                <div className="bento-item bento-2" ref={(el) => { if (el) bentoItemsRef.current[1] = el; }}>
                  <img src={bentoImages[1].url} alt="" />
                </div>
                <div className="bento-item bento-3" ref={(el) => { if (el) bentoItemsRef.current[2] = el; }}>
                  <img src={bentoImages[2].url} alt="" />
                </div>
                <div className="bento-item bento-4" ref={(el) => { if (el) bentoItemsRef.current[3] = el; }}>
                  <img src={bentoImages[3].url} alt="" />
                </div>
                <div className="bento-item bento-5" ref={(el) => { if (el) bentoItemsRef.current[4] = el; }}>
                  <img src={bentoImages[4].url} alt="" />
                </div>
                <div className="bento-item bento-6" ref={(el) => { if (el) bentoItemsRef.current[5] = el; }}>
                  <img src={bentoImages[5].url} alt="" />
                </div>
                <div className="bento-item bento-7" ref={(el) => { if (el) bentoItemsRef.current[6] = el; }}>
                  <img src={bentoImages[6].url} alt="" />
                </div>
                <div className="bento-item bento-8" ref={(el) => { if (el) bentoItemsRef.current[7] = el; }}>
                  <img src={bentoImages[7].url} alt="" />
                </div>
              </div>
              
              {/* Contenido */}
              <div className="ver-mas-content">
                <h2>¿Quieres ver más?</h2>
                <a href="#catalogo" className="btn-ver-catalogo">Ver Catálogo</a>
              </div>
            </section>

            <section id="sobre-nosotros" className="sobre-nosotros-section">
              <img src={logo} alt="Logo" className="sobre-nosotros-logo" ref={sobreNosotrosLogoRef} />
              <p className="sobre-nosotros-text" ref={sobreNosotrosTextRef}>Conoce un poco sobre Nosotros</p>
            </section>

            <section id="informacion" className="informacion-section">
              <div className="informacion-container">
                <div className="informacion-video">
                  <video autoPlay loop muted playsInline>
                    <source src="https://mediapool.bmwgroup.com/download/edown/tvFootageDownload.mp4?dokNo=PF0009759&actEvent=tvFootageH264" type="video/mp4" />
                  </video>
                </div>
                <div className="informacion-video">
                  <video autoPlay loop muted playsInline>
                    <source src={luxuryVideo} type="video/mp4" />
                  </video>
                </div>
                <div className="informacion-video">
                  <video autoPlay loop muted playsInline>
                    <source src="https://ferrari.scene7.com/is/content/ferrari/6628b794-2db2-4c91-9228-7cc0acc63687" type="video/mp4" />
                  </video>
                </div>
                <div className="informacion-content">
                  <h2 className="informacion-title">Todos los coches de lujo en un solo lugar</h2>
                  <p className="informacion-descripcion">
                    Descubre nuestra exclusiva colección de vehículos de alta gama. 
                    Desde deportivos exóticos hasta SUVs de lujo, ofrecemos la mejor 
                    selección de automóviles premium del mercado. Cada vehículo es 
                    cuidadosamente seleccionado para garantizar calidad, rendimiento y elegancia.
                  </p>
                </div>
              </div>
            </section>

            <section id="estadisticas" className="estadisticas-section" ref={estadisticasRef}>
              <div className="estadisticas-container">
                <div className="contador-wrapper">
                  <h2 className="contador" ref={contadorRef}>0+</h2>
                  <p className="texto-contador" ref={textoContadorRef}>Personas Confian en nosotros</p>
                </div>
                <div className="reviews-container">
                  <div className="review-card" ref={(el) => { if (el) reviewsRef.current[0] = el; }}>
                    <div className="review-stars">★★★★★</div>
                    <p className="review-text">
                      "Excelente servicio y atención. Encontré el auto de mis sueños a un precio increíble."
                    </p>
                    <p className="review-author">- Carlos M.</p>
                  </div>
                  <div className="review-card" ref={(el) => { if (el) reviewsRef.current[1] = el; }}>
                    <div className="review-stars">★★★★★</div>
                    <p className="review-text">
                      "La mejor experiencia comprando un vehículo de lujo. Totalmente recomendado."
                    </p>
                    <p className="review-author">- Ana G.</p>
                  </div>
                  <div className="review-card" ref={(el) => { if (el) reviewsRef.current[2] = el; }}>
                    <div className="review-stars">★★★★★</div>
                    <p className="review-text">
                      "Profesionalismo y calidad en cada detalle. Volví por mi segundo auto con ellos."
                    </p>
                    <p className="review-author">- Roberto L.</p>
                  </div>
                </div>
              </div>
            </section>

            <section className="transporte-section" ref={transporteRef}>
              <div 
                className="transporte-background" 
                ref={transporteImageRef}
                style={{
                  backgroundImage: 'url(https://preview.redd.it/lamborghini-revuelto-transport-v0-ru3ex07oaqte1.jpg?width=640&crop=smart&auto=webp&s=6110cf53cc1e0034f970c769d8cb04231adeda4f)'
                }}
              />
              <div className="transporte-container">
                <h2 className="transporte-title">Seguridad y transporte de inicio a fin</h2>
                <p className="transporte-descripcion">
                  Nos encargamos de todo el proceso de entrega con los más altos estándares de seguridad.
                  Transporte especializado y seguro garantizado desde nuestras instalaciones hasta tu hogar.
                </p>
              </div>
            </section>

            <section className="personalizacion-section" ref={personalizacionRef}>
              <video 
                className="personalizacion-video-bg"
                autoPlay 
                loop 
                muted 
                playsInline
              >
                <source src={costumize2} type="video/mp4" />
              </video>
              <div className="personalizacion-panels">
                <div 
                  className="personalizacion-panel"
                  ref={(el) => { if (el) personalizacionVideosRef.current[0] = el; }}
                />
                <div 
                  className="personalizacion-panel"
                  ref={(el) => { if (el) personalizacionVideosRef.current[1] = el; }}
                />
                <div 
                  className="personalizacion-panel"
                  ref={(el) => { if (el) personalizacionVideosRef.current[2] = el; }}
                />
                <div 
                  className="personalizacion-panel"
                  ref={(el) => { if (el) personalizacionVideosRef.current[3] = el; }}
                />
              </div>
              <div className="personalizacion-container">
                <h2 className="personalizacion-title">Personalización sin límites</h2>
              </div>
            </section>
          </main>
        </div>
      </div>
    </>
  );
}

export default App;
