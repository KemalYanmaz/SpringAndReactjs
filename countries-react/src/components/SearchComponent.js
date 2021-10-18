import React, { Component } from 'react'

export default class Search extends Component {

    componentDidMount(){
        this.props.searchByCapital("");
    }

    render() {

        return (
            <div>
                <div className="row mx-5">
                    <div className="col-6">
                        <label htmlFor="searchAll">Search For Any:</label>
                        <input id="searchAll" onChange={()=>this.searchForAll()} className="form-control " type="text"/>
                    </div>
                    <div className="col-6">
                        <label htmlFor="searchForCapital">Search:</label>
                        <input id="searchForCapital" onChange={()=>this.searchForCapital()} className="form-control " type="text"/>
                    </div>
                </div>
            </div>
        )
    }

    searchForCapital(){
        const text = document.getElementById('searchForCapital').value;
        this.props.searchByCapital(text);
    }

    searchForAll(){
        const text = document.getElementById('searchAll').value;
        this.props.searchAllColumns(text);
    }


}
