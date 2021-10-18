import axios from 'axios';

const COUNTRIES_REST_API_URL = 'http://localhost:8080/api/countries/';
const COUNTRIES_SEARCH_IN_CAPITAL = COUNTRIES_REST_API_URL + "capital/";
const COUNTRIES_SEARCH_IN_ALL = COUNTRIES_REST_API_URL + "search/";

class CountryService{

    getCountriesByCapital(capitalName){
            return this.convertIfEmpty(COUNTRIES_SEARCH_IN_CAPITAL,capitalName);
    }

    getCountriesByText(text){
        return this.convertIfEmpty(COUNTRIES_SEARCH_IN_ALL,text);
    }

    convertIfEmpty(URL,text){
        if(text!==""){
            return axios.get(URL+text);
        }
        return axios.get(COUNTRIES_REST_API_URL);
    }
}

export default new CountryService();