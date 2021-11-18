import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:4000';

const valid_query_list = {
	"car" : 1,
	"luxury" : 2,
	"armored" : 3,
	"commercial" : 4,
	"" : 5
}

class CarService {
	static list(query = "") {
		if (query in valid_query_list){
			return axios.get('/car',{ "params": { "filter": query } });	
		}
	    return undefined
	}
	static read(id) {
	    return axios.get('/car/' + id);
	}
	static create(obj) {
	    return axios.post('/car', JSON.stringify(obj));
	}
	static delete(id) {
	    return axios.delete('/car/' + id);
	}
}
export {CarService}