
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ViewSeed from './seed/ViewSeed';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/seed' Component={ViewSeed}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
