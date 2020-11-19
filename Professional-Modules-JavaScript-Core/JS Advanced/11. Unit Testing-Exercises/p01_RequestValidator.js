function validateRequest(obj) {
    if(obj.method === undefined || (obj.method !== 'GET' &&
        obj.method !== 'POST' &&
        obj.method !== 'DELETE' &&
        obj.method !== 'CONNECT')){
        throw new Error('Invalid request header: Invalid Method');
    }

    let uriRegex = /^[A-Za-z0-9\.]+$|[\*]$/g;
    if(obj.uri === undefined || !uriRegex.test(obj.uri)){
        throw new Error('Invalid request header: Invalid URI')
    }

    if(obj.version === undefined || (obj.version !== 'HTTP/0.9' &&
        obj.version !== 'HTTP/1.0' &&
        obj.version !== 'HTTP/1.1' &&
        obj.version !== 'HTTP/2.0')){
        throw new Error('Invalid request header: Invalid Version')
    }

    let messageRegex = /^[^<>\\&'"]*$/g;
    if(obj.message === undefined || !messageRegex.test(obj.message)){
        throw new Error('Invalid request header: Invalid Message')
    }

    return obj;
}

// validateRequest({
//     method: 'GET',
//     uri: 'svn.public.catalog',
//     version: 'HTTP/1.1',
//     message: ''
// });

validateRequest(
{
    method: 'POST',
        version: 'HTTP/2.0',
    message: 'rm -rf /*'
});

