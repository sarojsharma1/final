import { AuthResponse } from '../models/auth';

export function getAuthData(): AuthResponse {
  const authUser = localStorage.getItem('auth-user');
  return authUser
    ? JSON.parse(authUser)
    : {
        token: '',
        username: '',
        role: '',
      };
}

export function getAuthToken(): string | null {
  return localStorage.getItem('auth-token');
}

export function getUserRole(): string {
  return getAuthData().role;
}

export function getUsername(): string {
  return getAuthData().username;
}

export function isLoggedIn(): boolean {
  if (getAuthData().token !== '') {
    return true;
  } else {
    return false;
  }
}

// export function isAdmin(): boolean {
//   if (authData.role === '[ROLE_ADMIN]') {
//     return true;
//   } else {
//     return false;
//   }
// }

// export function isCustomer(): boolean {
//   if (authData.role === '[ROLE_USER]') {
//     return true;
//   } else {
//     return false;
//   }
// }

// export function isSupplier(): boolean {
//   if (authData.role === '[ROLE_Supplier]') {
//     return true;
//   } else {
//     return false;
//   }
// }
