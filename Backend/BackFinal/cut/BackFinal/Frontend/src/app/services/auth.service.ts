import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthRequest, AuthResponse } from '../models/auth';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private readonly http: HttpClient) {}

  register(user: User): Observable<User> {
    return this.http.post<User>(
      'http://localhost:8080/api/v1/auth/register',
      user
    );
  }

  login(user: AuthRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(
      'http://localhost:8080/api/v1/auth/login',
      user
    );
  }
}
