import jwt from 'jsonwebtoken';
import { config } from 'dotenv';
config();

export const generateToken = (data, access = true) => {
    const secret = access
        ? process.env.ACCESS_TOKEN_SECRET
        : process.env.REF_TOKEN_SECRET;
    const expiry = access
        ? process.env.ACCESS_TOKEN_EXPIRY
        : process.env.REF_TOKEN_EXPIRY;
    return jwt.sign(data, secret, { expiresIn: parseInt(expiry) });
};

export const verifyToken = (token, access = true) => {
    const secret = access
        ? process.env.ACCESS_TOKEN_SECRET
        : process.env.REF_TOKEN_SECRET;
    try {
        return jwt.verify(token, secret);
    } catch (err) {
        return {
            status: 401,
            message: `Unauthorized: ${err.message}`,
        };
    }
};