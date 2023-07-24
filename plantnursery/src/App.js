
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./home/Home";
import ViewSeed from './seed/ViewSeed';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' Component={Home}/>
          <Route path='/seed/view' Component={ViewSeed}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
