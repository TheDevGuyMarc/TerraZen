import React from 'react';
// import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import Dashboard from "./features/dashboard/pages/Dashboard";
import Equipment from "./features/equipment/pages/Equipment";
import Temperature from "./features/temperature/pages/Temperature";
import PH from "./features/ph/pages/PH";
import Lighting from "./features/lighting/pages/Lighting";
import ATO from "./features/ato/pages/ATO";
import Dosing from "./features/dosing/pages/Dosing";
import Misting from "./features/misting/pages/Misting";
import Waves from "./features/waves/pages/Waves";
import Timers from "./features/timer/pages/Timers";
import Macros from "./features/macro/pages/Macros";
import Settings from "./features/settings/pages/Settings";
import {Wrapper} from "./shared/components/Wrapper.styled";
import NavbarComponent from "./shared/components/NavbarComponent";
import FooterComponent from "./shared/components/FooterComponent";

function App() {
    /* TODO: Implement Loading Animation */

    /* TODO: Implement auth error display */

    /* TODO: Wrap with auth guard & give authenticated user as prop to pages */
    return (
        <Wrapper>
            <NavbarComponent/>

            <Routes>
                <Route path={"/"} element={<Dashboard/>}/>
                <Route path={"/equipment"} element={<Equipment/>}/>
                <Route path={"/temperature"} element={<Temperature/>}/>
                <Route path={"/ph"} element={<PH/>}/>
                <Route path={"/lighting"} element={<Lighting/>}/>
                <Route path={"/ato"} element={<ATO/>}/>
                <Route path={"/dosing"} element={<Dosing/>}/>
                <Route path={"/misting"} element={<Misting/>}/>
                <Route path={"/waves"} element={<Waves/>}/>
                <Route path={"/timers"} element={<Timers/>}/>
                <Route path={"/macros"} element={<Macros/>}/>
                <Route path={"/settings"} element={<Settings/>}/>
            </Routes>

            <FooterComponent/>
        </Wrapper>
    );

    /* TODO: Implement default display if not authenticated */
}

export default App;
