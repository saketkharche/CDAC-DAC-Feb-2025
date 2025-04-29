function fetchId(id) {
    return new Promise((resolve, reject) => {
        console.log("fetching id...");
        setTimeout(() => {
            var sq = {userId: id, name: "saket", phone: "9503027747", age: 23};
            var ids = [167, 124, 181, 101];
            if (ids) {
                resolve(ids);
            } else {
                reject("id not found!");
            }
        }, 1000);
    });
    fetchId().then()
}