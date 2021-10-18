import React from 'react';
class CountryList extends React.Component {

    render() {
        return (
            <div className="container my-3">
                <table className="table table-striped">
                    <thead>
                        <th>Name</th>
                        <th>Capital</th>
                        <th>Region</th>
                        <th>Flag</th>
                    </thead>
                    <tbody>
                        {
                            this.props.countries.map(
                                country =>
                                    <tr key={country.id}>
                                        <td>{country.name}</td>
                                        <td>{country.capital}</td>
                                        <td>{country.region}</td>
                                        <td><a href={country.flag} ><img alt={country.name} width="60" height="40" src={country.flag}></img></a></td>
                                    </tr>
                            )
                        }
                    </tbody>

                </table>

            </div>
        );
    }
}

export default CountryList;