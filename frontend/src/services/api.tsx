import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8082/api', 
  withCredentials: true,
});

export default api;
