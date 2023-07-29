
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Footer } from "./home/Footer";
import Header from "./home/Header";
import Home from "./home/Home";
import { ViewSites } from "./view/ViewSites";

function App() {
  return (
    <div className="App">
      <Header/>
      <BrowserRouter>
        <Routes>
          <Route path='/' Component={Home}/>
          <Route path='/view' Component={ViewSites}/>
        </Routes>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
