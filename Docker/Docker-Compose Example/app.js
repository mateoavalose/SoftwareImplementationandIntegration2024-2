const cron = require('node-cron');
const syncdb = require('./cron');
cron.schedule('*/5 * * * * *', () => {
    console.log('cron running every 5 seconds');
    syncdb.syncdb();
});