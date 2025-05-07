import { Contact } from "./component/Contact";
import { About } from "./component/About";
import { Home } from "./component/Home";
import { Navbar } from "./component/Navbar";
import { Mycomponent } from "./Mycomponent";

import { DemoComponent } from "./DemoComponent";

function App() {
  return (
    <BrowerRouter>
      <div>
        <Navbar></Navbar>
        <Routes>
          <Route path="/About" element={<About></About>}></Route>

          <Route path="/Contact" element={<Contact></Contact>}></Route>

          <Route path="/" element={<Home></Home>}></Route>
        </Routes>

        {/* <h1>hello world!</h1>
      <Mycomponent text="Hellow world"></Mycomponent>
      <DemoComponent></DemoComponent> */}
      </div>
    </BrowerRouter>
  );
}

export default App;
