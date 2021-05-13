var login = {
    template : '#loginTemp'
}
var register = {
    template : '#registerTemp'
}

const router = new VueRouter({
    routes: [
        { path : '/', redirect: '/login' },
        { path : '/login' , component : login },
        { path : '/register' , component : register }
    ]
})

var vm = new Vue({
    el:"#app",
    data:{},
    methods:{},
    router:router
})