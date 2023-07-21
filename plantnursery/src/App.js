
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ViewOrder from './order/ViewOrder';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/order' Component={ViewOrder}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
