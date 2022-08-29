import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { AuthRequest } from 'src/app/models/auth';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
    private location: Location
  ) {}

  username: string = '';
  password: string = '';

  userLogin: AuthRequest = {
    username: '',
    password: '',
  };

  ngOnInit(): void {
    console.log(this.location.getState());
  }

  onSubmit(): void {
    console.log(this.username, this.password);
    this.userLogin = {
      username: this.username,
      password: this.password,
    };

    this.authService.login(this.userLogin).subscribe({
      next: (res) => {
        console.log(res.role);
        localStorage.setItem('auth-token', res.token);
        localStorage.setItem('auth-user', JSON.stringify(res));
        if (res.role === '[ROLE_ADMIN]') {
          this.router.navigate(['admin']);
        } else if (res.role === '[ROLE_SUPPLIER]') {
          this.router.navigate(['product-detail']);
        } else {
          const navigation: any = this.location.getState();
          if (navigation.navigationId === 1) this.router.navigate(['/']);
          else this.location.back();
        }
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
