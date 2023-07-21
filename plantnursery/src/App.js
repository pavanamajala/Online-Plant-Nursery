
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CreateEditSeed from "./seed/CreateEditSeed";
import ViewSeed from './seed/ViewSeed';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/seed/view' Component={ViewSeed}/>
          <Route path='/seed/create' Component={CreateEditSeed}/>
          <Route path='/seed/edit/:seedId' Component={CreateEditSeed}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
