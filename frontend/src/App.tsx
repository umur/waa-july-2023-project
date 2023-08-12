import AppRoutes from './Routes';
import UserProvider from './context/UserProvider';

function App() {
  return (
    <UserProvider>
      <AppRoutes />
    </UserProvider>
  );
}

export default App;
