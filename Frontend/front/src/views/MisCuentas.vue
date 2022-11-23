<template>
    <img
        src="../playground_assets/imagen2022110220562846116177-tg1t-200h.png"
        alt="imagen2022110220562846116177"
        class="logo"
    />
    <div class="texto1">
        <pre>{{logo}}</pre>
    </div>
    <div class="cuadrado1" v-on:click="recuperar">
        <img
        src="../playground_assets/MisCuentas.png"
        alt="imagen2022110220562846116177"
        class="imagen1"
        />
        <span class="texto2">Mis Cuentas</span>
    </div>
    <div class="cuadrado2" v-on:click="recuperar">
        <img
        src="../playground_assets/HistorialTransacciones.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo}}</pre>
    </div>
    <div class="cuadrado3" v-on:click="recuperar">
        <img
        src="../playground_assets/realizarTransferencias.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo2}}</pre>
    </div>
    <div class="cuadrado4" v-on:click="recuperar">
        <img
        src="../playground_assets/pagosFacturas.png"
        alt="imagen2022110220562846116177"
        class="imagen3"
        />
        <pre class="texto4">Pagos de facturas</pre>
    </div>
    <div class="cuadrado5" v-on:click="recuperar">
        <img
        src="../playground_assets/pagosServicios.png"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Pagos de servicios</pre>
    </div>
    <div class="cuadrado6" v-on:click="recuperar">
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
    <span class="texto6">Nombre</span>
    <span class="texto7">Correo</span>
    <span class="texto8">Cuenta Corriente</span>
    <!--Desde aqui ya no es la barra lateral-->
    <span class="texto9">Mis Cuentas</span>
    <span class="texto10">Aqui se encuentran las cuentas que posee esta cuenta</span>
    <span class="texto11">Selecciones una cuenta</span>
    <div class="cuadrado7" >
        <span class="texto12">Cuenta Corriente</span>
    </div>
    <span class="texto13">Información de la cuenta</span>
    <span class="texto14">Numero de cuenta</span>
    <span class="texto15">1234567890123456</span>
    <span class="texto16">Tipo de cuenta</span>
    <span class="texto17">Cuenta Corriente</span>
    <span class="texto18">Balance</span>
    <span class="texto19">380.563</span>
</template>
<script>
export default {
    name:'MisCuentas',
    data(){
        return{
            prueba:true,
            logo:'Inversiones\nRoyale',
            titulo:'Historial de\ntransacciones',
            titulo2:'Realizar\ntransferencias'
        }
    },
    methods:{
        recuperar(){
            this.prueba=!this.prueba
        }
    }
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
  width: 200px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen1 {
  top: 10px;
  left: -80px;
  width: 75px;
  height: 70px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen2 {
  top: 10px;
  left: -80px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen3 {
  top: 10px;
  left: -95px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen4 {
  top: 10px;
  left: -100px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen5 {
  top:950px;
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
  top: 30px;
  left: 230px;
  font-size: 25px;
  color:#059669
}
.texto2 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -40px;
  left: 120px;
  font-size: 22px;
}
.texto3 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -80px;
  left: 120px;
  font-size: 22px;
}
.texto4 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -70px;
  left: 105px;
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
  top: 975px;
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
  top: 1025px;
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
  top: 1050px;
  left: 50px;
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
  top: 1075px;
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
  top: 250px;
  left: 645px;
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
  top: 475px;
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
  top: 575px;
  left: 550px;
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
  top: 650px;
  left: 550px;
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
  top: 575px;
  left: 850px;
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
  top: 650px;
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
  top: 575px;
  left: 1150px;
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
  top: 650px;
  left: 1150px;
  font-size: 22px;
  color:#667085
}
.cuadrado1 {
  top:200px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #E7EAEE;
  cursor: pointer;
}
.cuadrado2 {
  top:325px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado3 {
  top:450px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado4 {
  top:575px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado5 {
  top:700px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado6 {
  top:825px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado7 {
  top:275px;
  left: 645px;
  width: 300px;
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
</style>