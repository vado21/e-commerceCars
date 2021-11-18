import axios from 'axios';

axios.defaults.baseURL = 'http://6c10-2806-109f-13-3405-df0-d88a-f862-7db9.ngrok.io';


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