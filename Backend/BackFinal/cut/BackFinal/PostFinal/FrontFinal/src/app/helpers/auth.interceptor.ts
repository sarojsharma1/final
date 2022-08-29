import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { getAuthToken, isLoggedIn } from './authData';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor() {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let authToken = getAuthToken() ? getAuthToken() : '';
    console.log('Token', authToken);

    if (authToken !== '' && authToken !== null) {
      request = request.clone({
        setHeaders: {
          Authorization: `Basic ${authToken}`,
        },
      });
    }
    return next.handle(request);
  }
}
