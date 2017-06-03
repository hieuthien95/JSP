<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
//use Illuminate\Foundation\Auth\Access\AuthorizesResources;
use Illuminate\Support\Facades\Auth; // cho đăng nhập

class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, 
    	ValidatesRequests;

    function __construct() {
    	$this->middleware(function ($request, $next) {
            $this->user = Auth::user();
            $this->signed_in = Auth::check();

            if(Auth::user()) {
                view()->share('signed_in', $this->signed_in);
                view()->share('user_login', $this->user);
            }

            return $next($request);
        });
    }

    
}
