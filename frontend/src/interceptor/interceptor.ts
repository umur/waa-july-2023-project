import axios, { AxiosInstance, InternalAxiosRequestConfig } from "axios";

const http: AxiosInstance = axios.create({
  baseURL: "http://localhost:8080",
});

http.interceptors.request.use((config: InternalAxiosRequestConfig) => {
  const accessToken = localStorage.getItem("accessToken");

  if (accessToken) {
    config.headers["Authorization"] = `Bearer ${accessToken}`;
  }

  return config;
});

export default http;
