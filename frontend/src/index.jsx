import ReactDOM from 'react-dom/client';
import Home from './pages/Home.jsx';
import Header from './components/header.jsx';
import Footer from './components/footer.jsx';

ReactDOM.createRoot(document.getElementById('home')).render(<Home/>)
ReactDOM.createRoot(document.getElementById('header')).render(<Header/>)
ReactDOM.createRoot(document.getElementById('footer')).render(<Footer/>)