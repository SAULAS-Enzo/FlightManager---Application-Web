import './styles/global.css';
import { BrowserRouter  as Router, Routes, Route } from 'react-router-dom' ;
import Home from './pages/Home';
import Header from './components/header'
import Footer from './components/footer'
import EncyclopedieHome from './pages/encyclopedie/EncyclopedieHome';
import Resgister from './pages/inscription/Register';

function App() {
  return (
    <Router>
      <Header/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/home' element={<Home/>}/>
        <Route path='/encyclopedie' element={<EncyclopedieHome/>}/>
        <Route path='/register' element={<Resgister/>}/>
        <Route path='/operationnel' element={<Home/>}/>
        <Route path='/quizz' element={<Home/>}/>
        <Route path='/profile' element={<Home/>}/>
      </Routes>
      <Footer/>
    </Router>
  );
}

export default App;