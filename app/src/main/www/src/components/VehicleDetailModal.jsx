import { useEffect, useRef, useState } from 'react';
import './VehicleDetailModal.css';

const gsap = window.gsap;

const VehicleDetailModal = ({ vehiculo, onClose }) => {
  const modalRef = useRef(null);
  const overlayRef = useRef(null);
  const contentRef = useRef(null);
  const [currentImageIndex, setCurrentImageIndex] = useState(0);
  const imageRefs = useRef([]);
  const [isPurchasing, setIsPurchasing] = useState(false);
  const [purchaseComplete, setPurchaseComplete] = useState(false);

  useEffect(() => {
    // Animación de entrada
    if (overlayRef.current && contentRef.current) {
      gsap.set(overlayRef.current, { opacity: 0 });
      gsap.set(contentRef.current, { scale: 0.9, opacity: 0, y: 50 });

      gsap.to(overlayRef.current, {
        opacity: 1,
        duration: 0.3,
        ease: 'power2.out'
      });

      gsap.to(contentRef.current, {
        scale: 1,
        opacity: 1,
        y: 0,
        duration: 0.6,
        delay: 0.1,
        ease: 'power3.out'
      });
    }

    // Bloquear scroll del body
    document.body.style.overflow = 'hidden';

    return () => {
      document.body.style.overflow = '';
    };
  }, []);

  const handleClose = () => {
    gsap.to(contentRef.current, {
      scale: 0.9,
      opacity: 0,
      y: 50,
      duration: 0.4,
      ease: 'power2.in'
    });

    gsap.to(overlayRef.current, {
      opacity: 0,
      duration: 0.3,
      delay: 0.1,
      ease: 'power2.in',
      onComplete: onClose
    });
  };

  const handleOverlayClick = (e) => {
    if (e.target === e.currentTarget) {
      handleClose();
    }
  };

  const getImages = () => {
    if (vehiculo.media) {
      return vehiculo.media.filter(m => m.tipo === 'imagen').map(m => m.url);
    }
    return vehiculo.imagenes || [];
  };

  const images = getImages();

  const nextImage = () => {
    setCurrentImageIndex((prev) => (prev + 1) % images.length);
  };

  const prevImage = () => {
    setCurrentImageIndex((prev) => (prev - 1 + images.length) % images.length);
  };

  const generarPDF = () => {
    try {
      const fecha = new Date();
      const numeroOrden = `ORD-${fecha.getFullYear()}${(fecha.getMonth() + 1).toString().padStart(2, '0')}${fecha.getDate().toString().padStart(2, '0')}-${Math.floor(Math.random() * 10000).toString().padStart(4, '0')}`;
      const numeroTarjeta = `**** **** **** ${Math.floor(1000 + Math.random() * 9000)}`;
      
      // Crear contenido HTML del ticket
      const contenidoTicket = `
        <!DOCTYPE html>
        <html>
        <head>
          <meta charset="UTF-8">
          <style>
            body { font-family: 'Arial', sans-serif; padding: 40px; max-width: 800px; margin: 0 auto; }
            .header { text-align: center; border-bottom: 3px solid #000; padding-bottom: 20px; margin-bottom: 30px; }
            .header h1 { font-size: 32px; margin: 0; text-transform: uppercase; letter-spacing: 2px; }
            .header p { color: #666; margin: 5px 0; }
            .section { margin: 25px 0; }
            .section-title { font-size: 18px; font-weight: bold; border-bottom: 2px solid #eee; padding-bottom: 8px; margin-bottom: 15px; }
            .info-row { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #f5f5f5; }
            .info-label { font-weight: 600; color: #666; }
            .info-value { color: #000; font-weight: 600; }
            .vehicle-image { width: 100%; max-width: 500px; height: 300px; object-fit: cover; border-radius: 8px; margin: 20px auto; display: block; }
            .specs { background: #f9f9f9; padding: 20px; border-radius: 8px; margin: 20px 0; }
            .spec-item { padding: 8px 0; }
            .total { background: #000; color: #fff; padding: 20px; text-align: center; font-size: 28px; font-weight: bold; border-radius: 8px; margin: 30px 0; }
            .footer { text-align: center; margin-top: 40px; padding-top: 20px; border-top: 2px solid #eee; color: #666; font-size: 12px; }
          </style>
        </head>
        <body>
          <div class="header">
            <h1>Ticket de Compra</h1>
            <p>AutoExotic</p>
            <p>Fecha: ${fecha.toLocaleDateString('es-MX', { year: 'numeric', month: 'long', day: 'numeric' })}</p>
          </div>

          <div class="section">
            <div class="section-title">Información de la Orden</div>
            <div class="info-row">
              <span class="info-label">Número de Orden:</span>
              <span class="info-value">${numeroOrden}</span>
            </div>
            <div class="info-row">
              <span class="info-label">Fecha de Compra:</span>
              <span class="info-value">${fecha.toLocaleString('es-MX')}</span>
            </div>
            <div class="info-row">
              <span class="info-label">Método de Pago:</span>
              <span class="info-value">Tarjeta de Crédito ${numeroTarjeta}</span>
            </div>
          </div>

          <div class="section">
            <div class="section-title">Vehículo Adquirido</div>
            <img src="${images[0]}" alt="${vehiculo.nombre}" class="vehicle-image" onerror="this.style.display='none'" />
            <div class="info-row">
              <span class="info-label">Modelo:</span>
              <span class="info-value">${vehiculo.nombre}</span>
            </div>
            <div class="info-row">
              <span class="info-label">Tipo:</span>
              <span class="info-value">${vehiculo.tipo}</span>
            </div>
            <div class="info-row">
              <span class="info-label">Año:</span>
              <span class="info-value">${vehiculo.año}</span>
            </div>
            <div class="info-row">
              <span class="info-label">Categoría:</span>
              <span class="info-value">${vehiculo.categoria.charAt(0).toUpperCase() + vehiculo.categoria.slice(1)}</span>
            </div>
          </div>

          <div class="section">
            <div class="section-title">Especificaciones Técnicas</div>
            <div class="specs">
              <div class="spec-item"><strong>Motor:</strong> ${vehiculo.especificaciones.motor}</div>
              <div class="spec-item"><strong>Potencia:</strong> ${vehiculo.especificaciones.potencia}</div>
              <div class="spec-item"><strong>Velocidad Máxima:</strong> ${vehiculo.especificaciones.velocidadMaxima}</div>
              <div class="spec-item"><strong>Aceleración 0-100 km/h:</strong> ${vehiculo.especificaciones.aceleracion}</div>
              <div class="spec-item"><strong>Transmisión:</strong> ${vehiculo.especificaciones.transmision}</div>
              ${vehiculo.especificaciones.autonomia ? `<div class="spec-item"><strong>Autonomía:</strong> ${vehiculo.especificaciones.autonomia}</div>` : ''}
            </div>
          </div>

          <div class="total">
            TOTAL: ${vehiculo.precio}
          </div>

          <div class="section">
            <div class="section-title">Próximos Pasos</div>
            <p style="line-height: 1.8; color: #333;">
              Un asesor especializado se pondrá en contacto contigo en las próximas 24-48 horas para coordinar:
            </p>
            <ul style="line-height: 1.8; color: #333;">
              <li>Entrega personalizada del vehículo</li>
              <li>Documentación y registro</li>
              <li>Capacitación sobre las características del vehículo</li>
              <li>Servicios de mantenimiento premium</li>
            </ul>
          </div>

          <div class="footer">
            <p><strong>AutoExotic</strong></p>
            <p>Este es un documento de demostración generado automáticamente</p>
            <p>Para consultas: contacto@autoexotic.com | Tel: +52 (55) 1234-5678</p>
          </div>
        </body>
        </html>
      `;

      // Crear un blob y descargarlo
      const blob = new Blob([contenidoTicket], { type: 'text/html;charset=utf-8' });
      const url = URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.style.display = 'none';
      link.href = url;
      link.download = `Ticket_Compra_${vehiculo.nombre.replace(/\s+/g, '_')}_${numeroOrden}.html`;
      
      document.body.appendChild(link);
      
      // Forzar el click
      setTimeout(() => {
        link.click();
        
        // Limpiar después de un tiempo
        setTimeout(() => {
          document.body.removeChild(link);
          URL.revokeObjectURL(url);
        }, 100);
      }, 0);
      
      console.log('Descarga iniciada:', link.download);
    } catch (error) {
      console.error('Error al generar el comprobante:', error);
      alert('Error al generar el comprobante. Por favor, intenta nuevamente.');
    }
  };

  const handleComprar = async () => {
    setIsPurchasing(true);
    
    // Simular proceso de compra
    await new Promise(resolve => setTimeout(resolve, 2500));
    
    // Mostrar mensaje de éxito (sin descargar automáticamente)
    setIsPurchasing(false);
    setPurchaseComplete(true);
  };

  return (
    <div 
      ref={modalRef} 
      className="vehicle-detail-modal"
      onClick={handleOverlayClick}
    >
      <div ref={overlayRef} className="modal-overlay"></div>
      
      <div ref={contentRef} className="modal-content">
        <button className="modal-close" onClick={handleClose}>
          <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
            <line x1="18" y1="6" x2="6" y2="18"></line>
            <line x1="6" y1="6" x2="18" y2="18"></line>
          </svg>
        </button>

        <div className="modal-layout">
          {/* Galería de imágenes */}
          <div className="modal-gallery">
            <div className="gallery-main">
              <img 
                src={images[currentImageIndex]} 
                alt={`${vehiculo.nombre} - ${currentImageIndex + 1}`}
                className="gallery-main-image"
              />
              
              {images.length > 1 && (
                <>
                  <button className="gallery-nav gallery-prev" onClick={prevImage}>
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                      <polyline points="15 18 9 12 15 6"></polyline>
                    </svg>
                  </button>
                  <button className="gallery-nav gallery-next" onClick={nextImage}>
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                      <polyline points="9 18 15 12 9 6"></polyline>
                    </svg>
                  </button>
                </>
              )}
            </div>

            {images.length > 1 && (
              <div className="gallery-thumbnails">
                {images.map((img, index) => (
                  <div 
                    key={index}
                    className={`thumbnail ${index === currentImageIndex ? 'active' : ''}`}
                    onClick={() => setCurrentImageIndex(index)}
                  >
                    <img src={img} alt={`Thumbnail ${index + 1}`} />
                  </div>
                ))}
              </div>
            )}
          </div>

          {/* Información del vehículo */}
          <div className="modal-info">
            <div className="info-header">
              <span className="info-type">{vehiculo.tipo}</span>
              <h2 className="info-name">{vehiculo.nombre}</h2>
              <p className="info-description">{vehiculo.descripcion}</p>
            </div>

            <div className="info-specs">
              <h3 className="specs-title">Especificaciones</h3>
              <div className="specs-grid">
                <div className="spec-item">
                  <span className="spec-label">Motor</span>
                  <span className="spec-value">{vehiculo.especificaciones.motor}</span>
                </div>
                <div className="spec-item">
                  <span className="spec-label">Potencia</span>
                  <span className="spec-value">{vehiculo.especificaciones.potencia}</span>
                </div>
                <div className="spec-item">
                  <span className="spec-label">Velocidad Máxima</span>
                  <span className="spec-value">{vehiculo.especificaciones.velocidadMaxima}</span>
                </div>
                <div className="spec-item">
                  <span className="spec-label">0-100 km/h</span>
                  <span className="spec-value">{vehiculo.especificaciones.aceleracion}</span>
                </div>
                <div className="spec-item">
                  <span className="spec-label">Transmisión</span>
                  <span className="spec-value">{vehiculo.especificaciones.transmision}</span>
                </div>
                {vehiculo.especificaciones.autonomia && (
                  <div className="spec-item">
                    <span className="spec-label">Autonomía</span>
                    <span className="spec-value">{vehiculo.especificaciones.autonomia}</span>
                  </div>
                )}
              </div>
            </div>

            <div className="info-footer">
              <div className="price-section">
                <span className="price-label">Precio desde</span>
                <span className="price-value">{vehiculo.precio}</span>
              </div>
              <button className="btn-comprar" onClick={handleComprar} disabled={isPurchasing || purchaseComplete}>
                {isPurchasing ? (
                  <>
                    <div className="spinner"></div>
                    <span>Procesando...</span>
                  </>
                ) : purchaseComplete ? (
                  <>
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="3">
                      <polyline points="20 6 9 17 4 12"></polyline>
                    </svg>
                    <span>Compra Realizada</span>
                  </>
                ) : (
                  <>
                    <span>Comprar Ahora</span>
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                      <line x1="5" y1="12" x2="19" y2="12"></line>
                      <polyline points="12 5 19 12 12 19"></polyline>
                    </svg>
                  </>
                )}
              </button>
            </div>
          </div>
        </div>

        {/* Modal de éxito */}
        {purchaseComplete && (
          <div className="success-overlay">
            <div className="success-card">
              <div className="success-icon">
                <svg width="80" height="80" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                  <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
                  <polyline points="22 4 12 14.01 9 11.01"></polyline>
                </svg>
              </div>
              <h2 className="success-title">¡Gracias Por Tu Compra!</h2>
              <p className="success-message">
                Un asesor se contactará contigo para la entrega de tu <strong>{vehiculo.nombre}</strong>
              </p>
              <div className="success-actions">
                <button className="btn-download-ticket" onClick={generarPDF}>
                  <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                    <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
                    <polyline points="7 10 12 15 17 10"></polyline>
                    <line x1="12" y1="15" x2="12" y2="3"></line>
                  </svg>
                  Descargar Comprobante
                </button>
                <button className="btn-success-close" onClick={handleClose}>
                  Cerrar
                </button>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default VehicleDetailModal;
