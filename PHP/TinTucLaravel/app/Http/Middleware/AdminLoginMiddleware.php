<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth; // cho đăng nhập

class AdminLoginMiddleware
{
    public function handle($request, Closure $next) {
    	$user = Auth::user();
    	if($user) {
            if($user->quyen == 1 || $user->quyen == 2) 
            	return $next($request);
            else 
            	return redirect('trangchu');
        } 
        return redirect('admin/dangnhap');
    }
}
