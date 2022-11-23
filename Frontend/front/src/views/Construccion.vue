<template>
    <img
        src="../playground_assets/imagen2022110220562846116177-tg1t-200h.png"
        alt="imagen2022110220562846116177"
        class="logo"
    />
    <span class="texto1">Lo sentimos, pagina en construcción</span>
    <span class="texto2"> Haga click </span>
    <span v-on:click="retroceder" class="texto3">Aqui</span>
    <span class="texto4"> para volver </span>
</template>
<script>
export default{
    methods:{
        retroceder(){
            window.history.back();
        }
    }
}
</script>

<style scoped>
.logo {
  top: 100px;
  left: 520px;
  width: 400px;
  height: 200px;
  position: fixed;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.texto1 {
  display: flex;
  position: fixed;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 350px;
  left: 500px;
  font-size: 25px;
  color:#059669
}
.texto2 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 380px;
  left: 550px;
  font-size: 25px;
  color:#059669
}
.texto3{
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 380px;
  left: 680px;
  font-size: 25px;
  color:#4954d6;
  cursor: pointer;
}
.texto4 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 380px;
  left: 750px;
  font-size: 25px;
  color:#059669
}
</style>