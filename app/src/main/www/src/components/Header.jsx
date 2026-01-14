import './Header.css';

const Header = () => {
  return (
    <header className="header">
      <nav className="navbar">
        <a href="#vehiculos" className="nav-link">vehiculos</a>
        <a href="#catalogo" className="nav-link">catalogo</a>
        <a href="#pedido" className="nav-link">Mi pedido</a>
      </nav>
    </header>
  );
};

export default Header;
