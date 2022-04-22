function res = MagnetfeltFraStrom(B, I, r)
if B == 0
	res = (u_0*I)/(2*pi*r);
elseif I == 0
	res = B*2*pi*r/u_0;
elseif r == 0
	res = (u_0*I)/(B*2*pi);
end

