import CountryList from './components/CountryList';
import {Component } from 'react';
import CountryService from './services/CountryService';
import SearchComponent from './components/SearchComponent';
export default class App extends Component {

  state={metin:"",countries:[]}
  searchByCapital=capitalName=>{
    CountryService.getCountriesByCapital(capitalName).then((response)=>{
      this.setState({countries:response.data,metin:capitalName})
    });
  }

  searchAllColumns = text =>{
    CountryService.getCountriesByText(text).then((response)=>{
      this.setState({countries:response.data,metin:text})
    });
  }


  render(){
    return (
      <div className="container text-center">
        <h1>Country list</h1>
        <SearchComponent searchByCapital={this.searchByCapital} searchAllColumns={this.searchAllColumns}/>
        <CountryList countries={this.state.countries}/>
      </div>
    );
  }

}
