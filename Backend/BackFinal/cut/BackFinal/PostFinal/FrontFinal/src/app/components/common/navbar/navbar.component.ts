import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { getUsername, getUserRole, isLoggedIn } from 'src/app/helpers/authData';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor(private readonly router: Router) {}

  isCustomer: boolean = true;

  ngOnInit(): void {
    // console.log(this.isLoggedIn);
    this.isAdmin();
  }

  isLoggedIn() {
    return isLoggedIn();
  }

  getLoggedInUserName() {
    return getUsername();
  }

  onLogout() {
    localStorage.removeItem('auth-user');
    localStorage.removeItem('auth-token');
    this.router.navigate(['']);
  }

  isAdmin() {
    return getUserRole() === '[ROLE_ADMIN]' ? true : false;
  }
  isSupplier() {
    return getUserRole() === '[ROLE_SUPPLIER]' ? true : false;
  }
}
