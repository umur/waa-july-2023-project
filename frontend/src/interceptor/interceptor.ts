// import axios, { AxiosInstance, InternalAxiosRequestConfig } from "axios";

// const http: AxiosInstance = axios.create({
//   baseURL: "http://localhost:8080",
// });

// http.interceptors.request.use((config: InternalAxiosRequestConfig) => {
//   const accessToken = localStorage.getItem("accessToken");

//   if (accessToken) {
//     config.headers["Authorization"] = `Bearer ${accessToken}`;
//   }

//   return config;
// });

// export default http;


import axios, { AxiosInstance, InternalAxiosRequestConfig } from "axios";

const http: AxiosInstance = axios.create({
  baseURL: "http://localhost:8080",
});

http.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {
    const accessToken = localStorage.getItem('accessToken');
    //   const refreshToken = localStorage.getItem('refreshToken');
    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);
let isRefreshing = false;
http.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;
    const accessToken = localStorage.getItem('accessToken');
    const refreshToken = localStorage.getItem('refreshToken');

    // Check if the response status is 401 (Unauthorized) and a refresh token is available
    if (error.response.status === 401 && refreshToken && !isRefreshing) {
      isRefreshing = true;
      try {
        const response = await http.post('/uaa/refreshToken', {
          accessToken: accessToken,
          refreshToken: refreshToken,
        });

        // Update the new tokens in local storage
        const newToken = response.data.accessToken;
        const newRefreshToken = response.data.refreshToken;
        if (newToken != 'null') {
          localStorage.setItem('accessToken', newToken);
          localStorage.setItem('refreshToken', newRefreshToken);

          console.log('token refreshed');

          isRefreshing = false;

          // Update the authorization header with the new token
          http.defaults.headers.common['Authorization'] = `Bearer ${newToken}`;

          // Retry the original request with the updated token
          originalRequest.headers['Authorization'] = `Bearer ${newToken}`;
          return http(originalRequest);
        }
        else {
          throw error("refresh tocken expired");
        }
      } catch (refreshError) {
        // Handle the refresh token request error, e.g., logout the user
        console.log('Error refreshing token:', refreshError);
        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
        return Promise.reject(error);
      }

    }

    // Check if the response status is 403 (Forbidden)
    if (error.response.status === 403) {
      // Handle the 403 Forbidden error
      console.log('Access Forbidden');
      // Perform any necessary actions, such as displaying an error message or redirecting the user
      const accessToken = localStorage.getItem('accessToken');
      console.log(accessToken);
      if (accessToken == 'null') {
        localStorage.removeItem('accessToken');
        localStorage.removeItem('refreshToken');
      }
    }

    return Promise.reject(error);
  }
);

export default http;


