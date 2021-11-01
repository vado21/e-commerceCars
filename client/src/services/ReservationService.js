import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:4000';


class ReservationService{
static list () {
return axios.get('/reservation');
}
static list (id) {
return axios.get('/reservation/' + id);
}
static create (obj) {
return axios.post('/reservation', JSON.stringify(obj));
}
static delete (id) {
return axios.delete('/reservation/' + id);
}
}
export {ReservationService};