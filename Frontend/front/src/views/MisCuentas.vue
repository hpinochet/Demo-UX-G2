<template>
    <img
        src="../playground_assets/imagen2022110220562846116177-tg1t-200h.png"
        alt="imagen2022110220562846116177"
        class="logo"
    />

    <div class="texto1">
        <pre>{{logo}}</pre>
    </div>
    <div class="cuadrado1" v-on:click="cuenta">
        <img
        src="../playground_assets/MisCuentas.png"
        alt="imagen2022110220562846116177"
        class="imagen1"
        />
        <span class="texto2">Mis Cuentas</span>
    </div>
    <div class="cuadrado2" v-on:click="historial">
        <img
        src="../playground_assets/HistorialTransacciones.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo}}</pre>
    </div>
    <div class="cuadrado3" v-on:click="construccion">
        <img
        src="../playground_assets/realizarTransferencias.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo2}}</pre>
    </div>
    <div class="cuadrado4" v-on:click="facturas">
        <img
        src="../playground_assets/pagosFacturas.png"
        alt="imagen2022110220562846116177"
        class="imagen3"
        />
        <pre class="texto4">Pago facturas</pre>
    </div>
    <div class="cuadrado5" v-on:click="construccion">
        <img
        src="../playground_assets/pagosServicios.png"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Pago servicios</pre>
    </div>
    <div class="cuadrado6" v-on:click="construccion">
        <img
        src="../playground_assets/ajustes.svg"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Ajustes</pre>
    </div>
    <img
        src="../playground_assets/division.svg"
        alt="imagen2022110220562846116177"
        class="imagen5"
        />
    <span class="texto5">Perfil</span>
    <span class="texto6">{{usuario.username}}</span>
    <span class="texto7">{{usuario.tipo_cuenta}}</span>
    <div class="cuadradoCerrar" v-on:click="inicio">
        <img
        src="../playground_assets/logout.svg"
        alt="imagen2022110220562846116177"
        class="imagenCerrar"
        />
        <pre class="textoCerrar">Cerrar Sesión</pre>
    </div>
    <!--Desde aqui ya no es la barra lateral-->
    <span class="texto9">Mis Cuentas</span>
    <span class="texto10">Aquí puede encontrar sus cuentas</span>
    <span class="texto11">Seleccione una cuenta</span>
    <input class="cuadrado7" v-model="cuenta" placeholder="" :disabled="true"/>
    <span class="texto13">Información de la cuenta</span>
    <div class="cajaDato1"></div>
    <div class="cajaDato2"></div>
    <div class="cajaDato3"></div>
    <div class="cajaNumeroCuenta"></div>
    <span class="texto14">Numero de cuenta</span>
    <span class="texto15">{{usuario.numero_cuenta}}</span>
    <span class="texto16">Tipo de cuenta</span>
    <span class="texto17">{{usuario.tipo_cuenta}}</span>
    <span class="texto18">Balance</span>
    <span class="texto19">{{'$'+usuario.saldo}}</span>
</template>
<script>
import axios from 'axios'
export default {
    name:'MisCuentas',
    data(){
        return{
            prueba:true,
            logo:'Inversiones\nRoyale',
            titulo:'Historial de\ntransacciones',
            titulo2:'Realizar\ntransferencias',
            cuenta:'Cuenta Rut',
            usuario:[]
        }
    },
    methods:{
      cuenta(){
        this.$router.push("/MisCuentas/"+this.$route.params.id)
        },
      historial(){
        this.$router.push("/Historial/"+this.$route.params.id)
        },
      facturas(){
        this.$router.push("/Facturas/"+this.$route.params.id)
        },
      construccion(){
          this.$router.push("/construccion")
        },
        
        inicio(){
            this.$router.push("/")
        },
        async getUsuario(){
          const axiosInstance = axios.create({
              headers: {
                  "Access-Control-Allow-Origin": "*"
              }
          });
          
          let response = await axiosInstance.get('http://localhost:8888/cuenta/findCu/'+this.$route.params.id);
          this.usuario = response.data;
          console.log(this.usuario)
        }
    },
    created: async function(){
      this.getUsuario()
    },
}
</script>
<style scoped>
.pre {
  width:100%;
  border: solid;
}
.logo {
  top: 20px;
  left: 20px;
  width: 150px;
  height: 75px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-radius: 4px;
}
.imagen1 {
  top: 10px;
  left: -30px;
  width: 55px;
  height: 50px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen2 {
  top: 10px;
  left: -90px;
  width: 54px;
  height: 56px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen3 {
  top: 10px;
  left: -95px;
  width: 54px;
  height: 56px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen4 {
  top: 10px;
  left: -100px;
  width: 54px;
  height: 56px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen5 {
  top:175px;
  left: 20px;
  width: 350px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.texto1 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 8px;
  left: 180px;
  font-size: 23px;
  color:#059669
}
.texto2 {
  position: relative;
  margin-bottom: 100px;
  font-weight: bolder;
  top: 0px;
  left: 0px;
  font-size: 22px;
}
.texto3 {
  position: relative;
  margin-bottom: 24px;
  font-weight: bolder;
  top: -80px;
  left: 100px;
  font-size: 22px;
}
.texto4 {
  position: relative;
  margin-bottom: 24px;
  font-weight: bolder;
  top: -70px;
  left: 100px;
  font-size: 22px;
}
.texto5 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 100px;
  left: 50px;
  font-size: 22px;
  color:#64748B;
}
.texto6 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 125px;
  left: 50px;
  font-size: 18px;
}
.texto7 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 49px;
  font-size: 18px;
  color:#A0ABBB
}
.texto8 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 1050px;
  left: 50px;
  font-size: 18px;
}
.texto9 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 50px;
  left: 430px;
  font-size: 40px;
  color:#059669
}
.texto10 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 95px;
  left: 430px;
  font-size: 22px;
  color:#64748B
}
.texto11 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 190px;
  left: 780px;
  font-size: 14px;
}
.texto12 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 5px;
  left: 75px;
  font-size: 20px;
}
.texto13 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 305px;
  left: 600px;
  font-size: 50px;
}
.texto14 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 405px;
  left: 530px;
  font-size: 22px;
}
.texto15 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 480px;
  left: 580px;
  font-size: 22px;
  color:#667085
}
.texto16 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 405px;
  left: 820px;
  font-size: 22px;
}
.texto17 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 480px;
  left: 850px;
  font-size: 22px;
  color:#667085
}
.texto18 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 405px;
  left: 1120px;
  font-size: 22px;
}
.texto19 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 480px;
  left: 1120px;
  font-size: 22px;
  color:#667085
}
.cuadrado1 {
  top:200px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  border-color: rgba(1, 73, 4, 1);
  background-color: #E7EAEE;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
  object-fit: cover;
}
.cuadrado2 {
  top:270px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
}
.cuadrado3 {
  top:340px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
}
.cuadrado4 {
  top:410px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
}
.cuadrado5 {
  top:480px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
}
.cuadrado6 {
  top:550px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
}
.cuadrado7 {
  top: 215px;
  left: 760px;
  width: 200px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 1px;
  background-color: rgb(255, 255, 255);
  border-radius: 10px;
}
.cuadradoCerrar{
  top:650px;
  left: 10px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.imagenCerrar {
  top:0px;
  left: -70px;
  width: 30px;
  height: 15px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.textoCerrar {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -40px;
  left: 105px;
  font-size: 17px;
}
.cajaNumeroCuenta {
  top:390px;
  left: 500px;
  width: 801px;
  height: 50px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #E7EAEE;
  cursor: pointer;
}
.cajaDato1 {
  top:440px;
  left: 500px;
  width: 267px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  border-color: rgb(0, 0, 0);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 2px;
  border-radius: 0px;
}
.cajaDato2 {
  top:440px;
  left: 767px;
  width: 267px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  border-color: rgb(0, 0, 0);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 2px;
  border-radius: 0px;
}
.cajaDato3 {
  top:440px;
  left: 1034px;
  width: 267px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  border-color: rgb(0, 0, 0);
  background-color: #ffffff;
  cursor: pointer;
  border-style: solid;
  border-width: 2px;
  border-radius: 0px;
}
pre {
  width:50%;
}
</style>