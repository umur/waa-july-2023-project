export const useAuth = () => {
    let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
    return (user != null && user.accessToken != null && user.roles != null);
}