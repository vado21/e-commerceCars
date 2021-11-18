import axios from 'axios';

axios.defaults.baseURL = 'http://6c10-2806-109f-13-3405-df0-d88a-f862-7db9.ngrok.io';

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