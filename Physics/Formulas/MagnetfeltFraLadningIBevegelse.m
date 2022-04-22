function res = MagnetfeltFraLadningIBevegelse(B, q, v, vinkel_grad, r)
if B == 0
	res = (u_0/(4*pi))*(q*v*sind(vinkel_grad))/r^2;
end
end

