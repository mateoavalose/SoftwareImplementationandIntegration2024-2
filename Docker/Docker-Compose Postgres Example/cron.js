let times = 0;
const syncdb=()=>{
    times++;
    console.log('syncdb',times,'every 5 seconds');
    return times;
}
module.exports = {syncdb};