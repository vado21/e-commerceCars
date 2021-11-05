import axios from 'axios';

axios.defaults.baseURL = 'http://52d8-2806-109f-13-3016-e9e0-65ed-aed7-8efa.ngrok.io/';

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