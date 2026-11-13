import './styles/global.css';
import { BrowserRouter  as Router, Routes, Route } from 'react-router-dom' ;
import Home from './pages/Home';
import Header from './components/header'
import Footer from './components/footer'
import EncyclopedieHome from './pages/encyclopedie/EncyclopedieHome';

function App() {
  return (
    <Router>
      <Header/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/encyclopedie' element={<EncyclopedieHome/>}/>
      </Routes>
      <Footer/>
    </Router>
  );
}

export default App;