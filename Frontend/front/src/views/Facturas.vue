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
        <pre class="texto4">Pagos de facturas</pre>
    </div>
    <div class="cuadrado5" v-on:click="construccion">
        <img
        src="../playground_assets/pagosServicios.png"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Pagos de servicios</pre>
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
    <span class="texto6">Nombre</span>
    <span class="texto7">Correo</span>
    <span class="texto8">Cuenta Corriente</span>
    <div class="cuadradoCerrar" v-on:click="inicio">
        <img
        src="../playground_assets/logout.svg"
        alt="imagen2022110220562846116177"
        class="imagenCerrar"
        />
        <pre class="textoCerrar">Cerrar Sesión</pre>
    </div>
    <!--Desde aqui ya no es la barra lateral-->
    <span class="texto9">Pagos de facturas</span>
    <span class="texto10">Aqui se pueden realizar los pagos de facturas</span>
    <span class="texto11">Seleccione una factura</span>
    <select v-model="factura" class="drop1">
        <option v-for="transferencia in transferencias" v-bind:key="transferencia.id">{{transferencia.id}}</option>
    </select>
    <span class="texto12">Nombre Acreedor</span>
    <input class="cuadrado7" v-model="nombre" placeholder="Ej: Ricardo Gonzalez"/>
    <span class="texto13">Cuenta Acreedor</span>
    <input class="cuadrado8" v-model="nombre" placeholder="Ej: 5356 5495 5923 3259"/>
    <span class="texto14">Fecha de vencimiento</span>
    <datepicker class="cuadrado9" v-model="fecha" :icon-width="650"></datepicker>
    <span class="texto15">Monto</span>
    <input class="cuadrado10" v-model="monto" placeholder="Ej: 20.000"/>
    <span class="texto16">Mensaje</span>
    <input class="cuadrado11" v-model="mensaje" placeholder="..."/>
    <button v-on:click="pagar" class="boton-pago"> <span class="texto-17">Iniciar Sesión</span>  </button>
    <!--Popup pago exitoso-->
    <Transition name="modal">
    <div v-if="pagoExitoso" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-body">
            <slot name="body">Pago factura realizada con exito</slot>
          </div>
              <button
                class="modal-default-button"
                @click="pago()"
              ><p class="textoPopup">Aceptar</p></button>
        </div>
      </div>
    </div>
  </Transition>
  <!--Popup pago fallido-->
  <Transition name="modal">
    <div v-if="pagoFallido" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-body">
            <slot name="body">No tienes suficiente saldo para pagar esta factura</slot>
          </div>
              <button
                class="modal-default-button"
                @click="fallido()"
              ><p class="textoPopup">Aceptar</p></button>
        </div>
      </div>
    </div>
  </Transition>
</template>
<script>
import axios from 'axios'
import Datepicker from 'vuejs3-datepicker';
export default {
    name:'MisCuentas',
    components: {Datepicker},
    data(){
        return{
            prueba:true,
            logo:'Inversiones\nRoyale',
            titulo:'Historial de\ntransacciones',
            titulo2:'Realizar\ntransferencias',
            transferencias:[{'id':1,'numero':123,'nombre':'nombre1','fecha':'17/03/22','hora':'15:31','monto':'10.000'},{'id':2,'numero':1234,'nombre':'nombre2','fecha':'17/12/22','hora':'18:31','monto':'20.000'}],
            factura:'',
            nombre:'',
            fecha:new Date(),
            monto:'',
            mensaje:'',
            pagoExitoso:false,
            pagoFallido:false,
            usuario:[],
            facturas: null
        }
    },
    async mounted(){
      
      const axiosInstance = axios.create({
        headers: {
          "Access-Control-Allow-Origin": "*"
        }
      });

      let id = "637fef565918d9543961c46e"
      let response = await axiosInstance.get('http://localhost:8888/cuenta/allFC/' + id);
      this.facturas = response.data;
      console.log(this.transferencias)
      this.getUsuario()
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
        pago(){
          this.pagoExitoso=!this.pagoExitoso
        },
        fallido(){
          this.pagoFallido=!this.pagoFallido
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
  top: 150px;
  left: 430px;
  font-size: 17px;
}
.texto12 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 250px;
  left: 430px;
  font-size: 17px;
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
  top: 350px;
  left: 430px;
  font-size: 17px;
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
  top: 450px;
  left: 430px;
  font-size: 17px;
}
.texto15 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 550px;
  left: 430px;
  font-size: 17px;
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
  top: 650px;
  left: 430px;
  font-size: 17px;
}
.texto-17 {
  font-size: 17px;
  color:#ffffff
}
.textoPopup{
  color:#ffffff;
  font-size: 17px;
  top:-10px;
  position:relative;
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
  background-color: #ffffff;
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
  background-color: rgb(255, 255, 255);
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
  background-color: #E7EAEE;
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
  top: 270px;
  left: 430px;
  width: 780px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  border-width: 1px;
  background-color: rgb(255, 255, 255);
  border-radius: 10px;
}
.cuadrado8 {
  top: 370px;
  left: 430px;
  width: 780px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;  
  border-width: 1px;
  border-radius: 10px;
}
.cuadrado9 {
  top: 470px;
  left: 430px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;  
  border-width: 1px;
  border-radius: 10px;
}
.cuadrado10 {
  top: 570px;
  left: 430px;
  width: 780px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;  
  border-width: 1px;
  border-radius: 10px;
}
.cuadrado11 {
  top: 670px;
  left: 430px;
  width: 780px;
  height: 40px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;  
  border-width: 1px;
  border-radius: 10px;
}
.drop1 {
  position: absolute;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  cursor: pointer;
  top: 170px;
  left: 430px;
  font-size: 17px;
  width: 780px;
  height: 40px;
  border-width: 1px;
  background-color: rgb(255, 255, 255);
  border-radius: 10px;
}
.boton-pago {
  top: 770px;
  left: 430px;
  width: 780px;
  height: 40px;
  position: absolute;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25) ;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgb(14, 65, 15);
  border-style: solid;
  border-width: 1px;
  border-radius: 4px;
  background-color: rgb(4, 120, 87);
  cursor: pointer;
}
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-body {
  margin: 20px 0;
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 0px;
  left: 0px;
  font-size: 40px;
  color:#059669
}

.modal-default-button {
  cursor: pointer;
  top: 0px;
  left: 0px;
  width: 150px;
  height: 40px;
  position: relative;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25) ;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgb(14, 65, 15);
  border-style: solid;
  border-width: 1px;
  border-radius: 4px;
  background-color: #047857;
}
.modal-enter-from {
  opacity: 0;
}

.modal-leave-to {
  opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
.cuadradoCerrar{
  top:1110px;
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
</style>