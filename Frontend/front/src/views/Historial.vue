
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
    <div class="tabla" >
      <table class="table stripped bordered" border=1 frame=void rules=rows>
        <thead>
          <tr >
            <th>N° de transacción</th>
            <th>Nombre de depositante</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Monto</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="transferencia in transferencias">
            <td>{{ transferencia.numero }}</td>
            <td>Pago de factura-{{transferencia.username}}</td>
            <td>{{ transferencia.fecha }}</td>
            <td>{{ transferencia.hora }}</td>
            <td>${{ transferencia.monto }}</td>
          </tr>
        </tbody>

      </table>

    </div>
    <span class="texto9">Historial de transacciones</span>
    <span class="texto10">Aquí se encuentran las transacciones realizadas</span>
    <!--Popup nada-->
  <Transition name="modal">
    <div v-if="(transferencias.length==0)" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-body">
            <slot name="body">No tiene ninguna factura. Haga clic en el botón para ir a "Mis Cuentas"</slot>
          </div>
              <button
                class="modal-default-button"
                @click="cuenta()"
              ><p class="textoPopup">Mis Cuentas</p></button>
              
        </div>
      </div>
    </div>
  </Transition>
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
            transferencias:[{'fecha':new Date()}],
            usuario:[],
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
        async getTransacciones(){
          const axiosInstance = axios.create({
              headers: {
                  "Access-Control-Allow-Origin": "*"
              }
          });

          let response = await axiosInstance.get('http://localhost:8888/cuenta/allTr/'+this.$route.params.id);
          this.transferencias = response.data;
          console.log(this.transferencias)
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
      this.getTransacciones()
      this.getUsuario()
    },
}
</script>
<style scoped>
.pre {
  width:100%;
  border: solid;
}
.imagen6 {
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

.cuadrado7{
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
.tabla{
  top: 150px;
  left: 430px;
  position: absolute;
}
table {
  border-collapse: separate;
  border-spacing: 10px 0;
}
td {
  padding: 20px 0;
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
.textoPopup{
  color:#ffffff;
  font-size: 17px;
  top:-10px;
  position:relative;
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

.modal-header{
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  font-weight: bolder;
  top: 0px;
  left: 106px;
  font-size: 20px;
  color:#059669;
}

.modal-body {
  margin: 20px 0;
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  font-weight: bolder;
  top: 0px;
  left: 0px;
  font-size: 20px;
  color:#059669;
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
.cuadrado1 {
  top:200px;
  left: 20px;
  width: 320px;
  height: 70px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #E7EAEE;
  cursor: pointer;
  border-style: solid;
  border-width: 3px;
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
pre {
  width:50%;
}
</style>